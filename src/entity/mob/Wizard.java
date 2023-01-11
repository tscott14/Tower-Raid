package entity.mob;

import IO.Texture;
import entity.projectile.FireBall;

public class Wizard extends Creature {

	protected int id;
	private long last = System.currentTimeMillis();

	protected int speed = 1;

	public Wizard(int x, int y, Texture sprite) {
		super(x, y, 8, sprite);
		speed = 1;
		id = numOfCreatures;
		creatures.add((Wizard) this);
	}

	public void tick() {
		int xd = Player.Client.getX() - loc.getX();
		int yd = Player.Client.getY() - loc.getY();
		double dist = Math.sqrt((xd * xd) + (yd * yd));
		if (dist < 512) {
			if (dist > 128) move();
			if (System.currentTimeMillis() - last >= 0) {
				last = System.currentTimeMillis();
				if (!Player.Client.health.isDead()) {
					shoot(xd, yd);
				}
			}
		} else {
			getDir();
			if (!Collision(dx, dy)) {
				if (dx == 1) loc.addX(1);

				if (dx == -1) loc.addX(-1);
				if (dy == 1) loc.addY(1);
				if (dy == -1) loc.addY(-1);
			}
		}

		tickHealth();

	}

	protected void tickHealth() {
		if (beenHit(this)) this.health.damage(hitDamage);
		if (this.health.isDead()) destroy();
	}

	private void shoot(int xd, int yd) {
		double ang = Math.atan2(xd, -yd) - (Math.PI / 2);
		double dx = Math.cos(ang);
		double dy = Math.sin(ang);
		new FireBall(loc.getX(), loc.getY(), dx, dy, this);
	}

	protected void move() {
		if (!Collision(dx, dy)) {
			if (Player.Client.getX() > loc.getX()) loc.addX(1);
			if (Player.Client.getX() < loc.getX()) loc.addX(-1);
			if (Player.Client.getY() > loc.getY()) loc.addY(1);
			if (Player.Client.getY() < loc.getY()) loc.addY(-1);
		}
	}

}
