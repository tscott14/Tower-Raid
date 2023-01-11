package graphics;

import java.awt.Graphics;

import IO.Texture;
import entity.Entity;
import gui.GUI;
import gui.GUIButton;
import gui.GUIHealthBar;
import gui.GUIInventory;
import gui.GUIMiniMap;
import input.Keyboard;
import level.Level;
import utils.Vector4i;

public class GameDisplay extends Display {

	private GUI[] comp = new GUI[4];

	public GameDisplay() {
		loadGame();
		loadGUI();
	}

	private void loadGUI() {
		comp[0] = new GUIMiniMap(new Vector4i(Screen.UIBorder + 8, 32, 262, 290));
		comp[1] = new GUIHealthBar(new Vector4i(Screen.UIBorder + 8, 332, 260, 58));
		comp[2] = new GUIInventory(new Vector4i(Screen.UIBorder + 32, 396, 220, 300), Texture.t_inventory);
		comp[3] = new GUIButton(new Vector4i(Screen.UIBorder + 8, 700, 256, 32), 2, Texture.t_button02, "Pause");
	}

	private static void loadGame() {
		Level.loadLevels();
	}

	protected void render(Graphics _g) {
		GUI.renderComp(_g, comp);
		drawScreen(_g);
	}

	private void drawScreen(Graphics _g) {
		Screen.clear();
		Level.render();
		Entity.renderMobs();
		Entity.tickPlayer();
		Screen.filter();
	}

	protected void tick() {
		Keyboard.tick();
		Entity.tickMobs();
		Level.getCurrentLevel().tick();
		GUI.tickComp();
	}

}
