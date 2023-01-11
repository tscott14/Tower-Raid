package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import entity.mob.Player;
import utils.Vector4i;

public class GUIHealthBar extends GUIComp {
	private int bX;
	private final int BX;

	public GUIHealthBar(Vector4i _pos) {
		super(_pos, 0xff00ff);
		BX = Player.Client.health.getHealth() * 4;
	}

	public void update() {
		scroll(this);
		bX = Player.Client.health.getHealth() * 4;
	}

	public void draw(Graphics _g) {
		_g.setColor(Color.BLACK);
		_g.fillRect(pos.getX(), pos.getY() + yOff, BX, 24);
		_g.setColor(new Color(0xff0000));
		_g.fillRect(pos.getX(), pos.getY() + yOff, bX, 24);

		_g.setColor(Color.white);
		_g.setFont(new Font("Vergana", 10, 20));
		_g.drawString("Health: (" + Player.Client.health.getHealth() + ")", pos.getX(), pos.getY() + yOff - 10);
	}

}
