package entity.attrib.items;

import IO.Texture;

public abstract class Sword extends Item {

	public Sword(Texture _texture, int _damage, String _name, String _showName, String _desc) {
		super(1, _texture, false, true, _damage, _showName, _name, _desc);
	}

}
