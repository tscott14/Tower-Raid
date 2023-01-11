package entity.attrib;

import entity.Entity;
import entity.mob.Player;
import graphics.Screen;
import utils.Vector2i;

public class Health {
	private final int MAX_HEALTH;
	private int hearts;
	private Entity entity;
	private int healthBarLength, healthUnitLength = 8;

	public Health(int _MH, Entity _entity) {
		MAX_HEALTH = _MH;
		hearts = _MH;
		entity = _entity;
		healthBarLength = hearts * healthUnitLength;
	}

	public void damage(int amount) {
		if (amount < 0) {
			heal(-amount);
			return;
		}
		hearts -= amount;
		if (hearts < 0) hearts = 0;
		healthBarLength -= (amount * healthUnitLength);
	}

	public void heal(int amount) {
		if (amount < 0) {
			damage(-amount);
			return;
		}
		hearts += amount;
	}

	public boolean hasReachedMaxHealth() {
		return this.getHealth() == this.getMaxHealth();
	}

	public boolean isDead() {
		return hearts <= 0;
	}

	public int getMaxHealth() {
		return MAX_HEALTH;
	}

	public int getHealth() {
		return hearts;
	}

	public void kill() {
		hearts = 0;
	}

	public void render() {
		int sh = 10;
		int w = (Screen.getGameWidth() / 2) - (healthBarLength / 2);
		int h = 360;
		Vector2i pos = new Vector2i(w, h);
		Vector2i size = new Vector2i(w + healthBarLength, h + sh);
		Vector2i length = new Vector2i(entity.getX() - Player.Client.getX(), entity.getY() - Player.Client.getY());
		if (!(entity instanceof Player)) Screen.renderHealth(pos, size, length);
	}
}
