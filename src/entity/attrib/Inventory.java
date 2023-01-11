package entity.attrib;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import IO.Texture;
import entity.attrib.items.Air;
import entity.attrib.items.Bow;
import entity.attrib.items.Item;
import entity.attrib.items.WoodenSword;
import graphics.Screen;
import input.Keyboard;
import utils.Vector2i;
import utils.Vector4i;

public class Inventory {
	private int index;
	private Item[] items;

	public Inventory() {
		Item.loadItems();
		items = new Item[getColumn() * getRow()];
		index = 0;
		items[0] = new WoodenSword();
		items[1] = new Bow();

	}

	public int getColumn() {
		return 3;
	}

	public int getRow() {
		return 4;
	}

	public Item getItem(int _index) {
		if (items[_index] == null) return new Air();
		return items[_index];
	}

	public int getItemId(int _index) {
		return getItem(_index).getId();
	}

	public Item getCurrentlySelectedItem() {
		return getItem(getSelectedSlot());
	}

	public int getSelectedSlot() {
		return index;
	}

	public void changeSelectedSlot(int _index) {}

	public void putInSlot(int _index, Item _item) {
		items[_index] = _item;
	}

	public void emptySlot(int _index) {
		items[_index] = null;
	}

	public void swapSlots(int _ind1, int _ind2) {
		Item i = getItem(_ind1);
		Item j = getItem(_ind2);
		putInSlot(_ind1, j);
		putInSlot(_ind2, i);
	}

	public void tick() {
		if (Keyboard.getX() > Screen.UIBorder) {
			if (Keyboard.isKeyTyped(KeyEvent.VK_LEFT)) index--;
			if (Keyboard.isKeyTyped(KeyEvent.VK_RIGHT)) index++;
			if (Keyboard.isKeyTyped(KeyEvent.VK_UP)) index -= getColumn();
			if (Keyboard.isKeyTyped(KeyEvent.VK_DOWN)) index += getColumn();
		}
		if (index < 0) index = 12 + index;
		if (index > 11) index %= 12;
	}

	public void render(Vector2i _pos, Graphics _g) {
		int _x = _pos.getX();
		int _y = _pos.getY();
		int x = 0;
		int y = 0;
		int xOff = 0;
		for (int i = 0; i < items.length; i++) {
			Vector4i __pos = new Vector4i(_x + (x * 64), _y + (y * 64), 64, 64);
			if (items[i] != null) Screen.renderGraphicsArray(__pos, _g, items[i].texture.pixels);
			xOff += 64;
			x++;
			if (xOff > 128) {
				xOff = 0;
				y++;
				x = 0;
			}
		}
		Vector4i pos = new Vector4i(_x + ((index % 3) * 64), _y + ((index / 3) * 64), 64, 64);
		Screen.renderGraphicsArray(pos, _g, Texture.t_inventory_selection.pixels);
	}

}
