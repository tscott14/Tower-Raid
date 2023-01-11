package gui;

import java.awt.Color;
import java.awt.Graphics;

import IO.Texture;
import entity.mob.Player;
import graphics.Screen;
import utils.Vector2i;
import utils.Vector4i;

public class GUIInventory extends GUIComp {

	public GUIInventory(Vector4i _pos, Texture _texture) {
		super(_pos, _texture);
	}

	public void draw(Graphics _g) {
		Vector4i place = new Vector4i(pos.getX(), pos.getY() + yOff, 192, 256);
		if (texture.pixels != null) Screen.renderTexture(place, _g, texture.pixels);
		Player.Client.inventory.render(new Vector2i(pos.getX(), pos.getY() + yOff), _g);
		_g.setColor(Color.WHITE);
		_g.drawString("Inventory: [" + Player.Client.inventory.getItem(Player.Client.inventory.getSelectedSlot()).getShowName() + "]", pos.getX() - 12, pos.getY() + yOff - 10);

	}

	protected void createField() {
		field = new GUIField(new Vector4i(pos.getX() - 16, pos.getY() - 28, pos.getW() + 4, pos.getH()), true);
	}

	protected void update() {
		Player.Client.inventory.tick();
	}

}
