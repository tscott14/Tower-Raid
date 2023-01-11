package gui;

import java.awt.Color;
import java.awt.Graphics;

import IO.Texture;
import graphics.Screen;
import input.Keyboard;
import utils.Vector4i;

public abstract class GUIComp extends GUI {
	protected GUIField field;

	protected GUIComp(Vector4i _pos, int _col) {
		super(_pos);
		col = _col;
		createField();
	}

	protected GUIComp(Vector4i _pos, Texture _texture) {
		super(_pos);
		texture = _texture;
		col = 0x888888;
		createField();
	}

	protected void render(Graphics _g) {
		_g.setColor(new Color(col));
		field.render(_g);
		draw(_g);
	}

	protected abstract void draw(Graphics _g);

	protected void tick() {
		if (Keyboard.getX() >= Screen.UIBorder) tickScroll();
		field.tick();
		update();
	}

	protected abstract void update();

	protected void createField() {
		field = new GUIField(new Vector4i(pos.getX() - 4, pos.getY() - 28, pos.getW() + 4, pos.getH()), true);
	}

	protected static void scroll(GUI u) {

	}

}
