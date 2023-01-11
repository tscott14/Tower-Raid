package utils;

public class Vector2i extends Vector {
	protected int x, y;

	public Vector2i(int _x, int _y) {
		x = _x;
		y = _y;
	}

	public int getX() {
		return x;
	}

	public void setX(int _x) {
		x = _x;
	}

	public int getY() {
		return y;
	}

	public void setY(int _y) {
		y = _y;
	}

	public void addX(int _x) {
		x += _x;
	}

	public void addY(int _y) {
		y += _y;
	}

	public void tick() {

	}
}
