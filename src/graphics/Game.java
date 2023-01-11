package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import input.Keyboard;
import main.MainGameLoop;
import utils.States;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Thread thread;
	public int w, h;
	private String title;
	private final String version;
	public static int scale = 6;
	private BufferedImage image;
	private int[] pixels;

	public Game(int _w, int _h, String _title) {
		w = _w;
		h = _h;
		title = _title;
		version = title;
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		Screen.loadScreen(w, h, pixels);
		Display.loadDisplays();
		createFrame();
	}

	private void createFrame() {
		frame = new JFrame();
		frame.add(this);
		frame.pack();
		frame.setSize(w, h);
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public synchronized void start() {
		thread = new Thread(this, title);
		thread.start();
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60;
		double delta = 0;
		addKeyListener(Keyboard.getKeyboard());
		addMouseListener(Keyboard.getKeyboard());
		addMouseMotionListener(Keyboard.getKeyboard());
		addMouseWheelListener(Keyboard.getKeyboard());
		requestFocus();

		States.setInStartMenu();

		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (System.currentTimeMillis() - timer > 1000) timer += 1000;
			render();
			try {
				Thread.sleep((long) (1000/60.0));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, w, h, null);
		Display.drawUI(g);
		Display.renderScreen(g);
		g.setColor(new Color(0xffffff));
		g.setFont(new Font("Arial", 16, 16));
		g.drawString(version, 6, 14);
		g.dispose();
		bs.show();
	}

	private void tick() {
		Display.tickScreen();
	}

	public static int getW() {
		return MainGameLoop.w * 2;
	}

	public static int getH() {
		return MainGameLoop.h * 2;
	}

}
