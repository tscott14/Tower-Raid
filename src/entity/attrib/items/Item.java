package entity.attrib.items;

import java.util.ArrayList;
import java.util.List;

import IO.Texture;

public abstract class Item {
	protected final int id;
	protected List<Item> items = new ArrayList<Item>();
	protected int stack;

	public String desc;
	public Texture texture;
	public boolean canShoot, canSwing;
	private String name;
	private String showName;
	public int damage;
	public static int numOfItems = 1;

	protected Item(int _id, Texture _texture, boolean _shoot, boolean _swing, int _damage, String _showName, String _name, String _desc) {
		name = _name;
		desc = _desc;
		texture = _texture;
		showName = _showName;
		damage = _damage;
		numOfItems++;
		id = _id;
		canShoot = _shoot;
		canSwing = _swing;
		items.add(this);
	}

	protected Item(int _id, Texture _texture, String _showName, String _name, String _desc) {
		id = _id;
		desc = _desc;
		texture = _texture;
		showName = _showName;
		name = _name;
	}

	public String getName() {
		return name;
	}

	public String getShowName() {
		return showName;
	}

	public int getId() {
		return id;
	}

	public static void loadItems() {
		System.out.println("Loading Items... Successful");
	}
}
