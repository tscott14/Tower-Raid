package entity.mob;

import IO.Texture;

public class NPC extends Creature {

	public NPC(int _x, int _y, int _health, Texture _tex) {
		super(_x, _y, _health, _tex);
		creatures.add(this);
	}

	protected void move() {

	}

}
