package entity.projectile;

import IO.Texture;
import entity.Entity;
import entity.mob.Player;
import graphics.Screen;
import utils.Vector2i;

public class FireBall extends Projectile {

	public FireBall(int _x, int _y, double _dx, double _dy, Entity _e) {
		super(_x, _y, _dx, _dy, 10, 800, 8, Texture.t_fireBall, _e);

	}

	public void render() {
		double w_off = (((Screen.getGameWidth() / 2) - (this.tex.size / 2)) - Player.players.get(0).getX()) + this.x;
		double h_off = (((Screen.getGameHeight() / 2) - (this.tex.size / 2)) - Player.players.get(0).getY()) + this.y;
		Screen.renderProjectile(new Vector2i((int) w_off, (int) h_off), 0, tex);
	}

	public void setX(int _x) {
		this.x = _x;
	}

	public void setY(int _y) {
		this.y = _y;
	}
}
