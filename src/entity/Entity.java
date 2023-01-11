package entity;

import java.util.ArrayList;
import java.util.List;

import entity.mob.Creature;
import entity.mob.Mob;
import entity.mob.Player;
import entity.projectile.Projectile;
import graphics.Game;
import utils.Vector2i;

public abstract class Entity {
	protected Vector2i loc;

	public static List<Player> players = new ArrayList<Player>();
	public static List<Creature> creatures = new ArrayList<Creature>();
	public static List<Projectile> projectiles = new ArrayList<Projectile>();

	public Entity(int _x, int _y) {
		loc = new Vector2i((_x << Game.scale) + 32, (_y << Game.scale) + 32);
	}

	public static void tickPlayer() {
		Player.Client.tick();
	}

	public static void tickMobs() {
		for (int i = 0; i < players.size(); i++) {
			if (!players.get(i).equals(Player.Client)) players.get(i).tick();

		}
		for (int i = 0; i < creatures.size(); i++) {
			creatures.get(i).tick();

		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).tick();

		}
	}

	public static void renderMobs() {
		for (int i = 0; i < creatures.size(); i++) {
			creatures.get(i).render();
			creatures.get(i).health.render();
		}

		for (int i = 0; i < players.size(); i++) {
			players.get(i).render();
			players.get(i).health.render();

		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render();

		}

	}

	public static void newLevel() {
		destroyAllEntities();
	}

	public static void destroyAllEntities() {
		for (int i = 0; i < creatures.size(); i++) {
			creatures.get(i).destroy();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).destroy();
		}
		System.out.println("Killed All Entites");
	}

	public int getX() {
		return loc.getX();
	}

	public int getY() {
		return loc.getY();
	}

	public static boolean isCollidingWithProjectile(Mob _m1) {
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			if (p.spawner.getClass() != _m1.getClass()) {
				int dx = p.getX() - _m1.getX();
				int dy = p.getY() - _m1.getY();
				if ((dx >= -(_m1.getTexture().size / 2) && dx <= (_m1.getTexture().size / 2)) && (dy >= -(_m1.getTexture().size / 2) && dy <= (_m1.getTexture().size / 2))) {
					_m1.setHitDamage(p.damage);
					p.destroy();
					return true;
				}
			}
		}

		return false;
	}

	public static boolean isHit(Mob _m1) {
		if (_m1 instanceof Player) return false;
		for (int i = 0; i < creatures.size(); i++) {
			int xd = creatures.get(i).getX() - (Player.Client.getX());
			int yd = creatures.get(i).getY() - (Player.Client.getY());
			if (Math.sqrt((xd * xd) + (yd * yd)) < 100) {
				int dx = creatures.get(i).getX() - Player.Client.getHitLocation().getX();
				int dy = creatures.get(i).getY() - Player.Client.getHitLocation().getY();
				if (dx < 32 && dx > -32 && dy < 32 && dy > -32) {
					creatures.get(i).health.damage(Player.Client.inventory.getCurrentlySelectedItem().damage);
					Player.Client.getHitLocation().setX(0);
					Player.Client.getHitLocation().setY(0);
				}
			}
		}
		return false;
	}

}
