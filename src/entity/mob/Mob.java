package entity.mob;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import IO.Texture;
import entity.Entity;
import entity.attrib.Health;
import graphics.Game;
import level.Level;
import utils.Vector2i;

public abstract class Mob extends Entity {

	protected Texture texture;
	protected int dx = 0, dy = 0;
	protected Vector2i hitLocation;
	protected int hitDamage = 0;
	protected static Random rand = new Random();
	protected boolean destroyed = false;
	protected Health health;

	public Mob(int _x, int _y, Texture sprite) {
		super(_x, _y);
		this.texture = sprite;
		hitLocation = new Vector2i(0, 0);
	}

	public void renderMinimap(int _X0, int _Y0, Graphics _g) {
		double xRatio = this.getX() / (double) (Level.getW() << Game.scale);
		double yRatio = this.getY() / (double) (Level.getH() << Game.scale);
		int xPos = (int) ((xRatio * 256) + _X0);
		int yPos = (int) ((yRatio * 256) + _Y0);
		if (this instanceof Player) _g.setColor(Color.BLUE);
		else _g.setColor(Color.red);
		_g.fillOval(xPos, yPos, 10, 10);
	}

	protected boolean beenHit(Mob _m) {
		return Entity.isCollidingWithProjectile(_m) || Entity.isHit(_m);
	}

	public void tick() {

	}

	public void render() {

	}

	protected boolean Collision(int dx, int dy) {
		for (int c = 0; c < 4; c++) {
			int xt = ((loc.getX() + (dx)) + c % 2 * 63 - 32) / 64;
			int yt = ((loc.getY() + (dy)) + c / 2 * 63 - 32) / 64;
			if (Level.getTile(xt, yt).isSolid()) return true;
		}
		return false;
	}

	public Vector2i getHitLocation() {
		return hitLocation;
	}

	public int getTileX() {
		return getX() - ((Level.getW() << Game.scale) / 2);
	}

	public int getTileY() {
		return getY() - ((Level.getH() << Game.scale) / 2);
	}

	public int getCordX() {
		return getX() >> 6;
	}

	public int getCordY() {
		return getY() >> 6;
	}

	public Texture getTexture() {
		return texture;
	}

	public int getHitBy() {
		return hitDamage;
	}

	public void setHitDamage(int hitBy) {
		this.hitDamage = hitBy;
	}

}
