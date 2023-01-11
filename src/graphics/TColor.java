package graphics;

public abstract class TColor {
	public static int changeBrightness(int col, int amount) {
		int r, g, b;
		col = (col & 0xffffff) % 0xffffff;
		r = (col & 0xff0000) >> 16;
		g = (col & 0xff00) >> 8;
		b = col & 0xff;

		r += amount;
		g += amount;
		b += amount;

		if (r < 0) r = 0;
		if (g < 0) g = 0;
		if (b < 0) b = 0;
		if (r > 0xff) r = 0xff;
		if (g > 0xff) g = 0xff;
		if (b > 0xff) b = 0xff;

		int result = (r << 16) | (g << 8) | b;
		return result;
	}

	public static int avgColour(int _col1, int _col2) {
		int r = 0, g = 0, b = 0, r1, g1, b1, r2, g2, b2;
		_col1 = (_col1 & 0xffffff) % 0xffffff;
		r1 = (_col1 & 0xff0000) >> 16;
		g1 = (_col1 & 0xff00) >> 8;
		b1 = _col1 & 0xff;

		_col2 = (_col2 & 0xffffff) % 0xffffff;
		r2 = (_col1 & 0xff0000) >> 16;
		g2 = (_col1 & 0xff00) >> 8;
		b2 = _col1 & 0xff;

		r = (r1 + r2) / 2;
		g = (g1 + g2) / 2;
		b = (b1 + b2) / 2;

		if (r < 0) r = 0;
		if (g < 0) g = 0;
		if (b < 0) b = 0;
		if (r > 0xff) r = 0xff;
		if (g > 0xff) g = 0xff;
		if (b > 0xff) b = 0xff;

		int result = (r << 16) | (g << 8) | b;
		return result;
	}

	public static int changeContrast(int col, int from, int to, int amount) {
		int r, g, b;
		col = (col & 0xffffff) % 0xffffff;
		r = (col & 0xff0000) >> 16;
		g = (col & 0xff00) >> 8;
		b = col & 0xff;

		if (r < from) r -= amount;
		if (r > to) r += amount;
		if (g < from) g -= amount;
		if (g > to) g += amount;
		if (b < from) b -= amount;
		if (b > to) b += amount;

		if (r < 0) r = 0;
		if (g < 0) g = 0;
		if (b < 0) b = 0;
		if (r > 0xff) r = 0xff;
		if (g > 0xff) g = 0xff;
		if (b > 0xff) b = 0xff;

		int result = (r << 16) | (g << 8) | b;
		return result;
	}

	public static int imageOverlay(int pix1, int pix2) {
		int r, g, b;
		pix2 = pix2 & 0xffffff;
		pix1 = pix1 & 0xffffff;
		double amount = (pix2 & 0xff);

		r = (pix1 & 0xff0000) >> 16;
		g = (pix1 & 0xff00) >> 8;
		b = pix1 & 0xff;

		r -= amount;
		g -= amount;
		b -= amount;

		if (r < 0) r = 0;
		if (g < 0) g = 0;
		if (b < 0) b = 0;

		return (r << 16) | (g << 8) | b;
	}

	public static int increaseRed(int col) {
		int r1 = 0;

		int g = (col & 0xff00) >> 8;
		int b = col & 0xff;

		r1 = 255;

		return (0xff << 24) | (r1 << 16) | (g << 8) | b;
	}

	public static int desaterate(int pix1) {
		int r, g, b;

		r = (pix1 & 0xff0000) >> 16;
		g = (pix1 & 0xff00) >> 8;
		b = pix1 & 0xff;

		int col = (r + g + b) / 3;

		return (col << 16) | (col << 8) | col;
	}
}
