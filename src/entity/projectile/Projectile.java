package entity.projectile;

import IO.Texture;
import entity.Entity;
import entity.mob.Player;
import graphics.Game;
import graphics.Screen;
import level.Level;
import utils.Vector2i;

public abstract class Projectile extends Entity {

	protected double x, y;
	protected int speed, range;

	protected double dx, dy;
	public int damage;
	protected Texture tex;
	public Entity spawner;

	private int time = 0;

	public Projectile(int _x, int _y, double _dx, double _dy, int _speed, int _range, int _damage, Texture _tex, Entity _e) {
		super(_x, _y);
		x = _x;
		y = _y;
		dx = _dx;
		dy = _dy;
		speed = _speed;
		range = _range;
		spawner = _e;
		tex = _tex;
		damage = _damage;
		projectiles.add((Projectile) this);

	}

	public void render() {
		int w_off = (int) ((((Screen.getGameWidth() / 2) - (this.tex.size / 2)) - Player.players.get(0).getX()) + this.x);
		int h_off = (int) ((((Screen.getGameHeight() / 2) - (this.tex.size / 2)) - Player.players.get(0).getY()) + this.y);
		Screen.renderProjectile(new Vector2i(w_off, h_off), 0, tex);
	}

	public void tick() {
		x += dx * speed;
		y += dy * speed;
		time++;
		if (time >= range) {
			projectiles.remove(this);
		}
		collision();
	}

	public void collision() {
		int xa = ((int) x) >> Game.scale;
		int ya = ((int) y) >> Game.scale;
		if (Level.getTile((int) xa, (int) ya).isSolid()) this.destroy();
		for (int i = 0; i < Entity.creatures.size(); i++) {
			if (Entity.creatures.get(i).isIntercepted(xa, ya, tex.size)) this.destroy();
		}
	}

	public Texture getTex() {
		return tex;
	}

	public int getY() {
		return (int) y;
	}

	public int getX() {
		return (int) x;
	}

	public void destroy() {
		projectiles.remove(this);
	}
}
