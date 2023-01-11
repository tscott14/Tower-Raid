package graphics;

import java.awt.Color;
import java.awt.Graphics;

import utils.Vector2i;
import utils.Vector4i;

public abstract class Display {
	private static int index = 0;
	protected final Vector2i comPos = new Vector2i(Screen.UIBorder, 0);
	protected static Display[] displays = new Display[4];

	protected static Display startMenuDisplay = new StartMenuDisplay();
	protected static Display gameDisplay = new GameDisplay();
	protected static Display pauseGameDisplay = new PauseGameDisplay();

	public static void loadDisplays() {
		displays[0] = new StartMenuDisplay();
		displays[1] = new GameDisplay();
		displays[2] = new PauseGameDisplay();
		displays[3] = new OptionDisplay();
	}

	public static void renderScreen(Graphics _g) {
		getCurrentScreen().render(_g);
	}

	private static Display getCurrentScreen() {
		return displays[index];
	}

	public static void setDisplay(int _ind) {
		index = _ind;
	}

	protected abstract void render(Graphics _g);

	public static void tickScreen() {
		getCurrentScreen().tick();
	}

	protected abstract void tick();

	public static void drawUI(Graphics _g) {
		Vector4i pos = new Vector4i(Screen.UIBorder, 0, Screen.getScreenWidth(), Screen.getScreenHeight());
		_g.setColor(new Color(0x333333));
		_g.fillRect(pos.getX(), pos.getY(), pos.getW(), pos.getH());
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int _index) {
		index = _index;
	}

}
