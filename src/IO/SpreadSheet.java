package IO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import utils.Vector2i;

public class SpreadSheet {
	private Vector2i size;
	private String path;
	private int[] pixels;

	public static SpreadSheet tiles = new SpreadSheet("res/textures/tiles/tiles.png");

	private SpreadSheet(String _path) {
		path = _path;
		size = new Vector2i(0, 0);
		try {
			File file = new File(path);	
			BufferedImage img = ImageIO.read(file);
			size.setX(img.getWidth());
			size.setY(img.getHeight());
			pixels = new int[size.getX() * size.getY()];
			img.getRGB(0, 0, size.getX(), size.getY(), pixels, 0, size.getX());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int[] getTextureArray(int _size, int _x, int _y, SpreadSheet _sheet) {
		int[] pixs = new int[_size * _size];

		int xa = _x * _size;
		int ya = _y * _size;

		for (int y = 0; y < _size; y++) {
			for (int x = 0; x < _size; x++) {

				pixs[x + y * _size] = _sheet.pixels[(x + xa) + (y + ya) * _sheet.size.getX()];

			}
		}

		return pixs;
	}

}
