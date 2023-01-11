package graphics;

import java.awt.Color;
import java.awt.Graphics;

import IO.Texture;
import entity.mob.Player;
import level.tile.Tile;
import utils.Vector2i;
import utils.Vector4i;

public class Screen {
	public static boolean[] filters = new boolean[] { false, false, false };
	public static int[] pixels;
	private static int w, h;
	public static int UIBorder;
	private static final int ALPHA_COL = 0xffff00ff;

	public static void loadScreen(int _w, int _h, int[] _pixels) {
		w = _w;
		h = _h;
		UIBorder = w - (w - h);
		pixels = _pixels;
	}

	public static void renderGraphicsArray(Vector4i _pos, Graphics _g, int[] _pix) {
		int x0 = _pos.getX();
		int y0 = _pos.getY();
		int x1 = _pos.getW();
		int y1 = _pos.getH();
		for (int y = 0; y < y1; y++) {
			int ya = y0 + y;
			for (int x = 0; x < x1; x++) {
				int xa = x0 + x;
				if (_pix[x + y * x1] != ALPHA_COL) {
					_g.setColor(new Color(_pix[x + y * x1]));
					_g.drawRect(xa, ya, 1, 1);
				}
			}
		}
	}

	public static void renderTiles(Vector2i offSet, Tile Tile) {
		int xp = offSet.getX();
		int yp = offSet.getY();
		xp -= Player.Client.getX();
		yp -= Player.Client.getY();
		for (int y = 0; y < Tile.sprite.size; y++) {
			int ya = y + yp;
			for (int x = 0; x < Tile.sprite.size; x++) {
				int xa = x + xp;
				if (xa < -64 || xa >= UIBorder || ya < 0 || ya >= h) break;
				if (xa < 0) xa = 0;
				int col = Tile.sprite.pixels[x + y * Tile.sprite.size];
				pixels[xa + ya * w] = col;
			}
		}
	}

	public static void renderTexture(Vector2i pos, Texture _tex) {
		int xp = pos.getX();
		int yp = pos.getY();
		for (int y = 0; y < _tex.size; y++) {
			int ya = y + yp;
			for (int x = 0; x < _tex.size; x++) {
				int xa = x + xp;
				if (xa < -60 || xa >= UIBorder || ya < 0 || ya >= h) break;
				if (!((xa + ya * w) < 0 || (xa + ya * w) > pixels.length)) {
					int col = _tex.pixels[x + y * _tex.size];
					if (col != ALPHA_COL) pixels[xa + ya * w] = col;
				}
			}
		}
	}

	public static void renderTexture(Vector4i _pos, Graphics _g, int[] _pix) {
		renderMinimap(_pos, _g, _pix);
	}

	public static void renderHealth(Vector2i pos1, Vector2i pos2, Vector2i offSet) {
		int x0 = pos1.getX();
		int y0 = pos1.getY();
		int x1 = pos2.getX();
		int y1 = pos2.getY();
		int xp = offSet.getX();
		int yp = offSet.getY();

		for (int y = y0; y < y1; y++) {
			int ya = y + yp;
			for (int x = x0; x < x1; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= w || ya < 0 || ya >= h) break;
				int col = 0xff0000;
				if (col != ALPHA_COL) pixels[xa + ya * w] = col;
			}
		}
	}

	public static void fillRect(Vector2i _pos1, Vector2i _pos2, int _col) {
		for (int y = _pos1.getY(); y < _pos2.getY(); y++) {
			for (int x = _pos1.getX(); x < _pos2.getX(); x++) {
				if (x < 0 || x >= w || y < 0 || y >= h) break;
				pixels[x + (y * w)] = _col;
			}
		}
	}

	public static void filter() {
		// 0 = verga
		// 1 = deathFilter
		for (int i = 0; i < pixels.length; i++) {
			if (filters[1]) pixels[i] = TColor.increaseRed(pixels[i]);
			if (filters[0]) pixels[i] = TColor.imageOverlay(pixels[i], Texture.verga.pixels[i]);
			if (filters[2]) pixels[i] = TColor.desaterate(pixels[i]);
		}
	}

	public static void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public static void setDeadFilter(boolean _b) {
		filters[1] = _b;
	}

	public static void setVergaFilter(boolean _b) {
		filters[0] = _b;
	}

	public static void setPauseFilter(boolean _b) {
		filters[2] = _b;
	}

	public static void renderMinimap(Vector4i _pos, Graphics _g, int[] _pix) {
		renderGraphicsArray(_pos, _g, _pix);
	}

	public static void renderCreatures(Vector2i _pos, Texture _tex) {
		renderTexture(_pos, _tex);
	}

	public static void renderProjectile(Vector2i _pos, double _ang, Texture _tex) {
		renderTexture(_pos, _tex);
	}

	public static void renderComp(Vector2i pos1, Vector2i pos2, int _col) {
		fillRect(pos1, pos2, _col);
	}

	public static int getGameWidth() {
		return h;
	}

	public static int getGameHeight() {
		return h;
	}

	public static int getScreenWidth() {
		return w;
	}

	public static int getScreenHeight() {
		return h;
	}
}
