package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import IO.Texture;
import entity.mob.Player;
import graphics.Display;
import graphics.Screen;
import input.Keyboard;
import utils.Vector2i;
import utils.Vector4i;

public class GUIButton extends GUIComp {
	private Vector2i mousePos = new Vector2i(0, 0);
	private boolean mousePressed;
	private int type, time;
	private String text;

	public GUIButton(Vector4i _pos, int _type, Texture _texture, String _text) {
		super(_pos, _texture);
		type = _type;
		text = _text;
		time = 0;
		createField();
	}

	protected void createField() {
		field = new GUIField(new Vector4i(0, 0, 0, 0), true);
	}

	protected void tickButton() {
		if (entered()) {
			enteredAction();
		}
		if (exited()) {
			exitedAction();
		}
		if (pressed()) {
			pressedAction();
		}
		if (released()) {
			releasedAction();
		}
	}

	private void pressedAction() {
		// 0 = exit/quit button
		// 1 = play|ingame
		// 2 = pause
		// 3 = back to game from pause
		// 4 = options
		// 5 = toggle godmode
		switch (type) {
			case 0:
				System.exit(0);
				break;
			case 1:
				Display.setDisplay(1);
				break;
			case 2:
				Display.setDisplay(2);
				break;
			case 3:
				Screen.setPauseFilter(false);
				Display.setDisplay(1);
				break;
			case 4:
				Display.setDisplay(3);
				break;
			case 5:
				Player.Client.godMode = !Player.Client.godMode;
				break;
			default:
				break;
		}
	}

	private void releasedAction() {

	}

	private void enteredAction() {}

	private void exitedAction() {}

	public boolean entered() {
		return Vector2i.is2iIn4i(mousePos, pos);
	}

	public boolean exited() {
		return !Vector2i.is2iIn4i(mousePos, pos);
	}

	public boolean pressed() {
		return entered() && canClick();
	}

	public boolean released() {
		return false;
	}

	private boolean canClick() {
		if (mousePressed) {
			time++;
			if (time == 1) return true;
			else {
				return false;
			}
		} else if (!mousePressed) {
			time = 0;
		}
		return false;
	}

	private void updateMouse() {
		mousePos.setX(Keyboard.getX());
		mousePos.setY(Keyboard.getY());
		mousePressed = Keyboard.isMousePressed();
	}

	protected void draw(Graphics _g) {
		if (texture.pixels != null) Screen.renderTexture(pos, _g, texture.pixels);
		int height = 20;
		_g.setFont(new Font("Arial", Font.BOLD, height));
		_g.setColor(Color.WHITE);
		_g.drawString(text, pos.getX() + 128 - (5 * text.length()), (int) (pos.getY() + texture.getH() / 2));
	}

	protected void update() {
		updateMouse();
		tickButton();
	}

}
