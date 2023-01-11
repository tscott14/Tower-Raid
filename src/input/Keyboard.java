package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Keyboard implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	private static Keyboard k = new Keyboard();
	private boolean[] keys = new boolean[1024];
	private int x, y, d, mouseScroll, index;
	private boolean mousePressed;

	public static int getX() {
		return k.getKX();
	}

	public static int getY() {
		return k.getKY();
	}

	public static void tick() {
		k.mouseScroll = 0;
	}

	public static Keyboard getKeyboard() {
		return k;
	}

	public static boolean isKeyPressed(int _key) {
		return k.isKKeyPressed(_key);
	}

	public static boolean canClick() {
		return k.canKClick();
	}

	public static int getMouseScroll() {
		return k.getKMouseScroll();
	}

	public static boolean isKeyTyped(int _ind) {
		return k.isKKeyTyped(_ind);
	}

	public static boolean isMousePressed() {
		return k.isKMousePressed();
	}

	private boolean isKMousePressed() {
		return mousePressed;
	}

	public void keyPressed(KeyEvent e) {
		index = e.getKeyCode();
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		index = e.getKeyCode();
	}

	private boolean isKKeyTyped(int _ind) {
		if (_ind == index && keys[_ind]) {
			index = 0;
			return true;
		}
		return false;
	}

	private boolean isKKeyPressed(int i) {
		return keys[i];
	}

	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseEntered(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseExited(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mousePressed(MouseEvent e) {
		mousePressed = true;
		x = e.getX();
		y = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}

	private int getKX() {
		return x;
	}

	private int getKY() {
		return y;
	}

	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseScroll = e.getWheelRotation();
	}

	private int getKMouseScroll() {
		return mouseScroll;
	}

	private boolean canKClick() {
		if (mousePressed) {
			d++;
			if (d == 1) return true;
			else {
				return false;
			}
		} else if (!mousePressed) {
			d = 0;
		}
		return false;
	}

}
