package utils;

public class Vector4i extends Vector2i {
	private int w, h;

	public Vector4i(int _x, int _y, int _w, int _h) {
		super(_x, _y);
		w = _w;
		h = _h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void addW(int _w) {
		w += _w;
	}

	public void addH(int _h) {
		h += _h;
	}

	public void tick() {

	}

}
