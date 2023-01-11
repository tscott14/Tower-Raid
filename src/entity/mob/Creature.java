package entity.mob;

import IO.Texture;
import entity.attrib.Health;
import graphics.Screen;
import utils.Vector2i;

public abstract class Creature extends Mob {
	public static int numOfCreatures = 0;
	public int id = 0;
	public Health health;

	protected int boundX = loc.getX(), boundXX = loc.getX() + this.texture.size, boundY = loc.getY(), boundYY = loc.getY() + this.texture.size;

	public Creature(int _x, int _y, int _health, Texture _tex) {
		super(_x, _y, _tex);
		this.texture = _tex;
		health = new Health(_health, this);
		numOfCreatures++;
		id = numOfCreatures;
	}

	public void render() {
		if (!destroyed) {
			int w_off = (((Screen.getGameWidth() / 2) - (this.texture.size / 2)) - Player.players.get(0).getX()) + loc.getX();
			int h_off = (((Screen.getGameHeight() / 2) - (this.texture.size / 2)) - Player.players.get(0).getY()) + loc.getY();
			Screen.renderCreatures(new Vector2i(w_off, h_off), texture);
		}
	}

	public void tick() {
		if (!destroyed) {
			move();
			tickHealth();
		}
	}

	protected void tickHealth() {
		if (beenHit(this)) this.health.damage(1);
		if (this.health.isDead()) destroy();
	}

	protected void move() {
		getDir();
		if (!Collision(dx, dy)) {
			if (dx == 1) loc.setX(loc.getX() + 5);
			if (dx == -1) loc.setX(loc.getX() - 5);
			if (dy == 1) loc.setY(loc.getY() + 5);
			if (dy == -1) loc.setY(loc.getY() - 5);
		}
	}

	protected void getDir() {
		if ((System.currentTimeMillis()) % (rand.nextInt(1000) + 100) <= 10) {
			dx = rand.nextInt(3) - 1;
			dy = rand.nextInt(3) - 1;
		}
	}

	public boolean isIntercepted(int _x, int _y, int _size) {
		return false;
	}

	public void destroy() {
		creatures.remove(this);
		loc.setX(0);
		loc.setY(0);
		this.destroyed = true;
	}

}
