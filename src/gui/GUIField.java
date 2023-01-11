package gui;

import java.awt.Color;
import java.awt.Graphics;

import IO.Texture;
import utils.Vector4i;

public class GUIField extends GUI {

	private boolean fixed;

	public GUIField(Vector4i _pos, boolean _fixed) {
		super(_pos);
		fixed = _fixed;
	}

	public GUIField(Vector4i _pos, Texture _texture, boolean _fixed) {
		super(_pos);
		texture = _texture;
		fixed = _fixed;
	}

	public void render(Graphics _g) {
		_g.setColor(new Color(0x888888));
		if (fixed) {
			_g.fillRect(pos.getX(), pos.getY() + GUI.yOff, pos.getW(), pos.getH());
		} else {
			_g.fillRect(POS.getX(), POS.getY(), POS.getW(), POS.getH());
		}
	}

	public void tick() {

	}

}
