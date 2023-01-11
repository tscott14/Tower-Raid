package graphics;

import java.awt.Graphics;

import IO.Texture;
import gui.GUI;
import gui.GUIButton;
import utils.Vector4i;

public class OptionDisplay extends Display {

	private GUI[] comp = new GUI[3];

	public OptionDisplay() {
		loadGUI();
	}

	private void loadGUI() {
		comp[0] = new GUIButton(new Vector4i(Screen.UIBorder + 8, 700, 256, 32), 0, Texture.t_button02, "Quit");
		comp[1] = new GUIButton(new Vector4i(Screen.UIBorder + 8, 72, 256, 32), 5, Texture.t_button02, "Toggle Godmode");
		comp[2] = new GUIButton(new Vector4i(Screen.UIBorder + 8, 32, 256, 32), 3, Texture.t_button02, "Resume");
	}

	protected void render(Graphics _g) {
		GUI.renderComp(_g, comp);
	}

	protected void tick() {

	}

}
