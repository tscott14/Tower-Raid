package gui;

import java.awt.Graphics;

import IO.Texture;
import graphics.Screen;
import input.Keyboard;
import utils.Vector4i;

public abstract class GUI {
	public static int yOff;

	protected Texture texture;
	protected int col;
	protected static int y0Lim = 0;
	protected static int senc = 20;
	protected Vector4i pos;
	protected final Vector4i POS;

	protected GUI(Vector4i _pos) {
		pos = _pos;
		POS = _pos;
	}

	protected abstract void render(Graphics g);

	protected abstract void tick();

	public Vector4i getVector4i() {
		return pos;
	}

	protected static void tickScroll() {
		int ind = Keyboard.getMouseScroll();
		if (ind == 1) {
			y0Lim -= senc;
			yOff -= senc;
		} else if (ind == -1 && y0Lim < 0) {
			y0Lim += senc;
			yOff += senc;
		}
	}

	public static void renderComp(Graphics g, GUI[] gui) {
		for (int i = 0; i < gui.length; i++) {
			gui[i].render(g);
			gui[i].tick();
		}
	}

	public static void tickComp() {
		if (Keyboard.getX() >= Screen.UIBorder) {
			tickScroll();
		}
	}

}
