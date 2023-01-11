package entity.mob;

import java.awt.event.KeyEvent;

import IO.Texture;
import entity.attrib.Health;
import entity.attrib.Inventory;
import entity.projectile.Arrow;
import graphics.Screen;
import input.Keyboard;
import level.Level;
import utils.Time;
import utils.Vector2i;

public class Player extends Mob {

	public Health health;
	public Inventory inventory;
	public Time time;
	public boolean godMode = false;
	private boolean isProxy = false;
	private boolean canRegen = true;
	private int speed = 4;

	public static Player Client = new Player(5, 5, Texture.t_Player);

	public Player(int x, int y, Texture sprite) {
		super(x, y, sprite);
		System.out.println("Client Initialed");
		health = new Health(64, this);
		inventory = new Inventory();
		time = new Time();

		players.add((Player) this);
		Level.init();
	}

	public void render() {
		if (!isProxy) {
			int w_off = (Screen.getGameWidth() / 2) - (texture.size / 2);
			int h_off = (Screen.getGameHeight() / 2) - (texture.size / 2);
			Screen.renderCreatures(new Vector2i(w_off, h_off), texture);

			Screen.renderTexture(new Vector2i(0, 0), new Texture(32, "/gui/hearts_dead.png"));
		}
	}

	public void tick() {
		if (!this.health.isDead()) {
			tickHealth();
			move();
			updateHitVector();
		} else {
			Screen.filters[1] = true;
		}
	}

	private void updateHitVector() {
		if (inventory.getCurrentlySelectedItem().canSwing) swing();
		if (inventory.getCurrentlySelectedItem().canShoot) shoot();
	}

	private void swing() {
		if (Keyboard.canClick() && Keyboard.getX() < Screen.getGameWidth()) {
			int xPos = this.getX() + (Keyboard.getX() - (Screen.getGameWidth() / 2));
			int yPos = this.getY() + (Keyboard.getY() - (Screen.getGameHeight() / 2));
			hitLocation.setX(xPos);
			hitLocation.setY(yPos);
		}
	}

	private void tickHealth() {
		if (!godMode) {
			if (beenHit(this)) {
				this.health.damage(hitDamage);
				canRegen = false;
				time.wait(5, "s", true);
			}

			if (canRegen && !(this.health.hasReachedMaxHealth()) && time.isTimeUp()) {
				this.health.heal(1);
				time.wait(1, "s", true);
			}
			if (time.isTimeUp()) canRegen = true;
		}
	}

	private void shoot() {
		if (Keyboard.canClick() && Keyboard.getX() < Screen.getGameWidth()) {
			int mouseX = (int) ((Keyboard.getX() - (Screen.getGameWidth() / 2)));
			int mouseY = (int) ((Keyboard.getY() - (Screen.getGameHeight() / 2)));
			double ang = Math.atan2(mouseY, mouseX);
			double dx = Math.cos(ang);
			double dy = Math.sin(ang);
			new Arrow(this.getX(), this.getY(), dx, dy, this);
		}
	}

	private void move() {
		getDir();

		if (!(Collision(dx, 0)) && !this.isProxy && !this.health.isDead()) {
			loc.addX(dx);
			

		} if(!(Collision(0, dy)) && !this.isProxy && !this.health.isDead()){
			loc.addY(dy);
		}else if (this.isProxy) {
			// Multiplayer code here
		}

	}

	private void getDir() {
		dx = 0;
		dy = 0;
		if (Keyboard.isKeyPressed(KeyEvent.VK_W)) dy = -1;
		if (Keyboard.isKeyPressed(KeyEvent.VK_A)) dx = -1;
		if (Keyboard.isKeyPressed(KeyEvent.VK_S)) dy = 1;
		if (Keyboard.isKeyPressed(KeyEvent.VK_D)) dx = 1;
		dy *= speed;
		dx *= speed;
	}

	public void kill() {
		this.health.kill();
	}

}
