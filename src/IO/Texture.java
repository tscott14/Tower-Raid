package IO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
	public int size, w, h;

	public int[] pixels;
	public String path;

	// TransferTiles
	public static Texture t_empty = new Texture(64, "/textures/tiles/empty.png");
	public static Texture t_grassToDirt01 = new Texture(64, SpreadSheet.getTextureArray(64, 0, 0, SpreadSheet.tiles));
	public static Texture t_grassToDirt02 = new Texture(64, SpreadSheet.getTextureArray(64, 1, 0, SpreadSheet.tiles));
	public static Texture t_grassToDirt03 = new Texture(64, SpreadSheet.getTextureArray(64, 2, 0, SpreadSheet.tiles));
	public static Texture t_grassToDirt04 = new Texture(64, SpreadSheet.getTextureArray(64, 0, 1, SpreadSheet.tiles));
	public static Texture t_grassToDirt06 = new Texture(64, SpreadSheet.getTextureArray(64, 2, 1, SpreadSheet.tiles));
	public static Texture t_grassToDirt07 = new Texture(64, SpreadSheet.getTextureArray(64, 0, 2, SpreadSheet.tiles));
	public static Texture t_grassToDirt08 = new Texture(64, SpreadSheet.getTextureArray(64, 1, 2, SpreadSheet.tiles));
	public static Texture t_grassToDirt09 = new Texture(64, SpreadSheet.getTextureArray(64, 2, 2, SpreadSheet.tiles));

	public static Texture t_dirtToGrass01 = new Texture(64, SpreadSheet.getTextureArray(64, 3, 0, SpreadSheet.tiles));
	public static Texture t_dirtToGrass02 = new Texture(64, SpreadSheet.getTextureArray(64, 4, 0, SpreadSheet.tiles));
	public static Texture t_dirtToGrass03 = new Texture(64, SpreadSheet.getTextureArray(64, 5, 0, SpreadSheet.tiles));
	public static Texture t_dirtToGrass04 = new Texture(64, SpreadSheet.getTextureArray(64, 3, 1, SpreadSheet.tiles));
	public static Texture t_dirtToGrass06 = new Texture(64, SpreadSheet.getTextureArray(64, 5, 1, SpreadSheet.tiles));
	public static Texture t_dirtToGrass07 = new Texture(64, SpreadSheet.getTextureArray(64, 3, 2, SpreadSheet.tiles));
	public static Texture t_dirtToGrass08 = new Texture(64, SpreadSheet.getTextureArray(64, 4, 2, SpreadSheet.tiles));
	public static Texture t_dirtToGrass09 = new Texture(64, SpreadSheet.getTextureArray(64, 5, 2, SpreadSheet.tiles));

	public static Texture t_grassToSand01 = new Texture(64, SpreadSheet.getTextureArray(64, 0, 3, SpreadSheet.tiles));
	public static Texture t_grassToSand02 = new Texture(64, SpreadSheet.getTextureArray(64, 1, 3, SpreadSheet.tiles));
	public static Texture t_grassToSand03 = new Texture(64, SpreadSheet.getTextureArray(64, 2, 3, SpreadSheet.tiles));
	public static Texture t_grassToSand04 = new Texture(64, SpreadSheet.getTextureArray(64, 0, 4, SpreadSheet.tiles));
	public static Texture t_grassToSand06 = new Texture(64, SpreadSheet.getTextureArray(64, 2, 4, SpreadSheet.tiles));
	public static Texture t_grassToSand07 = new Texture(64, SpreadSheet.getTextureArray(64, 0, 5, SpreadSheet.tiles));
	public static Texture t_grassToSand08 = new Texture(64, SpreadSheet.getTextureArray(64, 1, 5, SpreadSheet.tiles));
	public static Texture t_grassToSand09 = new Texture(64, SpreadSheet.getTextureArray(64, 2, 5, SpreadSheet.tiles));

	public static Texture t_sandToGrass01 = new Texture(64, SpreadSheet.getTextureArray(64, 3, 3, SpreadSheet.tiles));
	public static Texture t_sandToGrass02 = new Texture(64, SpreadSheet.getTextureArray(64, 4, 3, SpreadSheet.tiles));
	public static Texture t_sandToGrass03 = new Texture(64, SpreadSheet.getTextureArray(64, 5, 3, SpreadSheet.tiles));
	public static Texture t_sandToGrass04 = new Texture(64, SpreadSheet.getTextureArray(64, 3, 4, SpreadSheet.tiles));
	public static Texture t_sandToGrass06 = new Texture(64, SpreadSheet.getTextureArray(64, 5, 4, SpreadSheet.tiles));
	public static Texture t_sandToGrass07 = new Texture(64, SpreadSheet.getTextureArray(64, 3, 5, SpreadSheet.tiles));
	public static Texture t_sandToGrass08 = new Texture(64, SpreadSheet.getTextureArray(64, 4, 5, SpreadSheet.tiles));
	public static Texture t_sandToGrass09 = new Texture(64, SpreadSheet.getTextureArray(64, 5, 5, SpreadSheet.tiles));

	public static Texture t_grassToGraybrick01 = new Texture(64, SpreadSheet.getTextureArray(64, 0, 6, SpreadSheet.tiles));
	public static Texture t_grassToGraybrick02 = new Texture(64, SpreadSheet.getTextureArray(64, 1, 6, SpreadSheet.tiles));
	public static Texture t_grassToGraybrick03 = new Texture(64, SpreadSheet.getTextureArray(64, 2, 6, SpreadSheet.tiles));
	public static Texture t_grassToGraybrick04 = new Texture(64, SpreadSheet.getTextureArray(64, 0, 7, SpreadSheet.tiles));
	public static Texture t_grassToGraybrick06 = new Texture(64, SpreadSheet.getTextureArray(64, 2, 7, SpreadSheet.tiles));
	public static Texture t_grassToGraybrick07 = new Texture(64, SpreadSheet.getTextureArray(64, 0, 8, SpreadSheet.tiles));
	public static Texture t_grassToGraybrick08 = new Texture(64, SpreadSheet.getTextureArray(64, 1, 8, SpreadSheet.tiles));
	public static Texture t_grassToGraybrick09 = new Texture(64, SpreadSheet.getTextureArray(64, 2, 8, SpreadSheet.tiles));

	public static Texture t_grassToRedbrick01 = new Texture(64, SpreadSheet.getTextureArray(64, 3, 6, SpreadSheet.tiles));
	public static Texture t_grassToRedbrick02 = new Texture(64, SpreadSheet.getTextureArray(64, 4, 6, SpreadSheet.tiles));
	public static Texture t_grassToRedbrick03 = new Texture(64, SpreadSheet.getTextureArray(64, 5, 6, SpreadSheet.tiles));
	public static Texture t_grassToRedbrick04 = new Texture(64, SpreadSheet.getTextureArray(64, 3, 7, SpreadSheet.tiles));
	public static Texture t_grassToRedbrick06 = new Texture(64, SpreadSheet.getTextureArray(64, 5, 7, SpreadSheet.tiles));
	public static Texture t_grassToRedbrick07 = new Texture(64, SpreadSheet.getTextureArray(64, 3, 8, SpreadSheet.tiles));
	public static Texture t_grassToRedbrick08 = new Texture(64, SpreadSheet.getTextureArray(64, 4, 8, SpreadSheet.tiles));
	public static Texture t_grassToRedbrick09 = new Texture(64, SpreadSheet.getTextureArray(64, 5, 8, SpreadSheet.tiles));

	// Whole Tiles
	public static Texture t_dirt01 = new Texture(64, SpreadSheet.getTextureArray(64, 15, 0, SpreadSheet.tiles));
	public static Texture t_grass01 = new Texture(64, SpreadSheet.getTextureArray(64, 15, 1, SpreadSheet.tiles));
	public static Texture t_sand01 = new Texture(64, SpreadSheet.getTextureArray(64, 15, 2, SpreadSheet.tiles));
	public static Texture t_redbrick01 = new Texture(64, SpreadSheet.getTextureArray(64, 15, 3, SpreadSheet.tiles));
	public static Texture t_greybrick01 = new Texture(64, SpreadSheet.getTextureArray(64, 15, 4, SpreadSheet.tiles));
	public static Texture t_water01 = new Texture(64, SpreadSheet.getTextureArray(64, 15, 5, SpreadSheet.tiles));

	// The sprites of the mobs/players
	public static Texture t_Player = new Texture(64, "/textures/entities/mobs/Client.png");
	public static Texture t_mob = new Texture(64, "/textures/entities/mobs/mob.png");
	public static Texture t_fireBall = new Texture(32, "/textures/entities/projectiles/fireball.png");
	public static Texture t_arrow = new Texture(32, "/textures/entities/projectiles/arrow.png");

	// The textures of the items
	public static Texture t_wooden_sword = new Texture(64, "/textures/items/wooden_sword.png");

	// These are going to be the filters
	public static Texture verga = new Texture(1080, 810, "/textures/items/wooden_sword.png");

	// The gui components
	public static Texture t_inventory = new Texture(192, 256, "/gui/inventory.png");
	public static Texture t_inventory_selection = new Texture(64, 64, "/gui/inventory_selection.png");
	public static Texture t_health_live = new Texture(32, 32, "/gui/hearts_live.png");
	public static Texture t_health_dead = new Texture(32, 32, "/gui/hearts_dead.png");

	// GUI startmenu ext
	public static Texture t_start_screen = new Texture(1080, 800, "/gui/options_menu.png");
	public static Texture t_options_menu = new Texture(1080, 800, "/gui/options_menu.png");
	public static Texture t_button01 = new Texture(256, 64, "/gui/button01.png");
	public static Texture t_button02 = new Texture(256, 32, "/gui/button02.png");

	public Texture() {
		size = 0;
	}

	public Texture(int size, int[] pixels) {
		this.size = size;
		if (pixels.length == 0) System.out.println("no");
		this.pixels = new int[size * size];
		for (int i = 0; i < pixels.length; i++) {
			this.pixels[i] = pixels[i];
		}
	}

	public Texture(int _w, int _h, String path) {
		w = _w;
		h = _h;
		pixels = new int[_w * _h];
		try {
			File file = new File("res"+path);	
			System.out.println("Loading " + file.getPath());
			BufferedImage img = ImageIO.read(file);
			int w = img.getWidth();
			int h = img.getHeight();
			img.getRGB(0, 0, w, h, pixels, 0, w);
			for (int i = 0; i < pixels.length; i++) {
				pixels[i] = pixels[i];
				// System.out.println(Integer.toHexString(pixels[i]));
			}
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}

	public Texture(int size, String path) {
		this.size = size;
		this.path = path;
		pixels = new int[size * size];
		try {
			File file = new File("res"+path);	
			System.out.println("Loading " + file.getPath());
			BufferedImage img = ImageIO.read(file);
			int w = img.getWidth();
			int h = img.getHeight();
			img.getRGB(0, 0, w, h, pixels, 0, w);

		} catch (Exception e) {
			System.out.println("File not found "+path);
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int getSize() {
		return size;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public static Texture rotSprite(double ang, Texture sp) {
		// int[] prePixels = new int[sp.pixels.length];
		for (double i = 0; i < 2 * Math.PI; i += (Math.PI / 24)) {
			// System.out.println(i);
		}
		return sp;
	}
}