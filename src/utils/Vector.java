package utils;

public abstract class Vector {

	public static boolean is2iIn4i(Vector2i ti, Vector4i fi) {
		int x = fi.getX();
		int y = fi.getY();
		int w = fi.getW() + x;
		int h = fi.getH() + y;
		int x1 = ti.getX();
		int y1 = ti.getY();
		if ((x1 > x && x1 < w) && (y1 > y && y1 < h)) return true;
		return false;
	}
}
