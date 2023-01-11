package graphics;

import java.awt.Graphics;

import IO.Texture;
import entity.Entity;
import gui.GUI;
import gui.GUIButton;
import level.Level;
import utils.Vector4i;

public class PauseGameDisplay extends Display {
	private GUI[] comp = new GUI[2];

	public PauseGameDisplay() {
		loadGUI();
	}

	private void loadGUI() {
		comp[0] = new GUIButton(new Vector4i(Screen.UIBorder + 8, 32, 256, 32), 3, Texture.t_button02, "Resume");
		comp[1] = new GUIButton(new Vector4i(Screen.UIBorder + 8, 110, 256, 32), 4, Texture.t_button02, "Options");
	}

	protected void render(Graphics _g) {
		Screen.setPauseFilter(true);
		Screen.clear();
		Level.render();
		Entity.renderMobs();
		Screen.filter();
		GUI.renderComp(_g, comp);
	}

	protected void tick() {
		GUI.tickComp();
	}

}
