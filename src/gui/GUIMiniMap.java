package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import entity.Entity;
import entity.mob.Player;
import graphics.Game;
import graphics.Screen;
import level.Level;
import utils.Vector4i;

public class GUIMiniMap extends GUIComp {

	public GUIMiniMap(Vector4i _pos) {
		super(_pos, 0xff00ff);
	}

	public void draw(Graphics _g) {
		if (!(pos.getX() == 0 || pos.getY() == 0)) {
			Screen.renderMinimap(new Vector4i(pos.getX(), pos.getY() + yOff, 256, 256), _g, Level.getCurrentLevel().getMipmapTexture().pixels);
			drawMobs(_g);
		}
		_g.setColor(Color.white);
		_g.setFont(new Font("Vergana", 10, 20));
		_g.drawString("Minimap: [" + (Player.Client.getX() >> Game.scale) + ", " + (Player.Client.getY() >> Game.scale) + "]", pos.getX(), pos.getY() - 10 + yOff);
	}

	private void drawMobs(Graphics _g) {
		for (int i = 0; i < Player.players.size(); i++) {
			Player.players.get(i).renderMinimap(pos.getX(), pos.getY() + yOff, _g);
		}
		for (int i = 0; i < Entity.creatures.size(); i++) {
			Entity.creatures.get(i).renderMinimap(pos.getX(), pos.getY() + yOff, _g);
		}

	}

	public void update() {
		scroll(this);
	}
}
