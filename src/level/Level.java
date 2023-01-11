package level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import IO.Texture;
import entity.Entity;
import entity.mob.Player;
import entity.mob.Wizard;
import graphics.Game;
import graphics.Screen;
import level.tile.Tile;
import utils.Time;

public class Level {

	private int w, h;
	private int[] tiles;
	private Texture mipmap;
	private static int currentLevel = 0;
	private Time time;
	public int timeOfDay;
	private int state;
	public static Level[] Levels = new Level[8];

	public Level(String _path, String _mipmapPath) {
		currentLevel = 0;
		timeOfDay = 0;
		state = 0;
		time = new Time();
		importTiles(_path);
		mipmap = new Texture(256, 256, _mipmapPath);
	}

	public static void init() {
		getCurrentLevel().initMobs();
	}

	private void initMobs() {
		switch (currentLevel) {
		case 0:
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			new Wizard(10, 10, Texture.t_mob);
			break;
		default:
			System.exit(1);
			break;
		}
	}

	private void importTiles(String _path) {
		BufferedImage img;
		try {
			File file = new File(_path);
			img = ImageIO.read(file);
			int w = img.getWidth();
			int h = img.getHeight();
			this.w = w;
			this.h = h;
			tiles = new int[w * h];
			img.getRGB(0, 0, w, h, tiles, 0, w);

		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = tiles[i] & 0xffffff;
		}
	}

	public static void loadLevels() {
		Level.Levels[0] = new Level("/levels/level01.png", "/levels/level01_mipmap.png");
	}

	public void renderLevel() {
		int x0 = Player.Client.getCordX() - 8;
		int y0 = Player.Client.getCordY() - 8;
		int x1 = Player.Client.getCordX() + 8;
		int y1 = Player.Client.getCordY() + 8;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				if (x < 0 || y < 0 || x >= w || y >= h)
					continue;
				getTile(x + y * w).render((x << Game.scale) + (Screen.getGameWidth() / 2),
						(y << Game.scale) + (Screen.getGameHeight() / 2));
			}
		}
	}

	public static void render() {
		getCurrentLevel().renderLevel();
	}

	public void tick() {
		timeOfDay++;
		if (time.isTimeUp()) {
			state++;
			time.wait(200, "ms", true);
		}
		if (timeOfDay > Integer.MAX_VALUE / 4)
			timeOfDay = 0;
		if (state > Integer.MAX_VALUE / 4)
			state = 0;
	}

	private Tile getTile(int index) {
		int app;
		if (index < 0 || index >= tiles.length)
			index = 0;
		app = tiles[index];

		// static tiles
		if (app == 0x10)
			return Tile.t_dirt01;
		if (app == 0x20)
			return Tile.t_grass01;
		if (app == 0x30)
			return Tile.t_sand01;
		if (app == 0x40)
			return Tile.t_redbrick01;
		if (app == 0x50)
			return Tile.t_greybrick01;
		if (app == 0x60)
			return Tile.t_water01;

		if (app == 0x11)
			return Tile.t_grassToDirt01;
		if (app == 0x12)
			return Tile.t_grassToDirt02;
		if (app == 0x13)
			return Tile.t_grassToDirt03;
		if (app == 0x14)
			return Tile.t_grassToDirt04;
		if (app == 0x16)
			return Tile.t_grassToDirt06;
		if (app == 0x17)
			return Tile.t_grassToDirt07;
		if (app == 0x18)
			return Tile.t_grassToDirt08;
		if (app == 0x19)
			return Tile.t_grassToDirt09;

		if (app == 0x21)
			return Tile.t_dirtToGrass01;
		if (app == 0x22)
			return Tile.t_dirtToGrass02;
		if (app == 0x23)
			return Tile.t_dirtToGrass03;
		if (app == 0x24)
			return Tile.t_dirtToGrass04;
		if (app == 0x26)
			return Tile.t_dirtToGrass06;
		if (app == 0x27)
			return Tile.t_dirtToGrass07;
		if (app == 0x28)
			return Tile.t_dirtToGrass08;
		if (app == 0x29)
			return Tile.t_dirtToGrass09;

		if (app == 0x31)
			return Tile.t_sandToGrass01;
		if (app == 0x32)
			return Tile.t_sandToGrass02;
		if (app == 0x33)
			return Tile.t_sandToGrass03;
		if (app == 0x34)
			return Tile.t_sandToGrass04;
		if (app == 0x36)
			return Tile.t_sandToGrass06;
		if (app == 0x37)
			return Tile.t_sandToGrass07;
		if (app == 0x38)
			return Tile.t_sandToGrass08;
		if (app == 0x39)
			return Tile.t_sandToGrass09;

		if (app == 0x3a)
			return Tile.t_grassToSand01;
		if (app == 0x3b)
			return Tile.t_grassToSand03;
		if (app == 0x3c)
			return Tile.t_grassToSand06;
		if (app == 0x3d)
			return Tile.t_grassToSand08;

		if (app == 0x41)
			return Tile.t_grassToRedbrick01;
		if (app == 0x42)
			return Tile.t_grassToRedbrick02;
		if (app == 0x43)
			return Tile.t_grassToRedbrick03;
		if (app == 0x44)
			return Tile.t_grassToRedbrick04;
		if (app == 0x46)
			return Tile.t_grassToRedbrick06;
		if (app == 0x47)
			return Tile.t_grassToRedbrick07;
		if (app == 0x48)
			return Tile.t_grassToRedbrick08;
		if (app == 0x49)
			return Tile.t_grassToRedbrick09;

		if (app == 0x51)
			return Tile.t_grassToGreybrick01;
		if (app == 0x52)
			return Tile.t_grassToGreybrick02;
		if (app == 0x53)
			return Tile.t_grassToGreybrick03;
		if (app == 0x54)
			return Tile.t_grassToGreybrick04;
		if (app == 0x56)
			return Tile.t_grassToGreybrick06;
		if (app == 0x57)
			return Tile.t_grassToGreybrick07;
		if (app == 0x58)
			return Tile.t_grassToGreybrick08;
		if (app == 0x59)
			return Tile.t_grassToGreybrick09;

		// animated Tiles
		// if (state % 2 == 0) if (app == 0xff0f) return Tile.t_water01;
		// if (state % 2 == 1) if (app == 0xff0f) return Tile.t_water02;

		return Tile.t_empty;
	}

	public static Level getCurrentLevel() {
		return Levels[currentLevel];
	}

	public static Tile getTile(int _xa, int _ya) {
		return Level.getCurrentLevel().getTile(_xa + _ya * getW());

	}

	public static int getW() {
		return getCurrentLevel().w;
	}

	public static int getH() {
		return getCurrentLevel().h;
	}

	public int[] getTileArray() {
		return tiles;
	}

	public Texture getMipmapTexture() {
		return mipmap;
	}

	public void nextLevel() {
		loadNextLevel();
		Entity.newLevel();
	}

	private void loadNextLevel() {
		init();
	}

	public void setTile(double x, double y, Tile tile) {
		int xa = (int) x;
		int ya = (int) y;
		tiles[xa + ya * getW()] = 0x10;
	}
}
