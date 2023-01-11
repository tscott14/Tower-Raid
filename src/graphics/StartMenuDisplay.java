package graphics;

import java.awt.Color;
import java.awt.Graphics;

import IO.Texture;
import gui.GUI;
import gui.GUIButton;
import utils.Vector4i;

public class StartMenuDisplay extends Display {

	private GUI[] comp = new GUI[3];

	public StartMenuDisplay() {
		loadGUI();
	}

	private void loadGUI() {
		comp[0] = new GUIButton(new Vector4i(Screen.UIBorder + 8, 564, 256, 64), 1, Texture.t_button01, "Play");
		comp[1] = new GUIButton(new Vector4i(Screen.UIBorder + 8, 632, 256, 64), 4, Texture.t_button01, "Options");
		comp[2] = new GUIButton(new Vector4i(Screen.UIBorder + 8, 700, 256, 64), 0, Texture.t_button01, "Quit");
	}

	protected void render(Graphics _g) {
		drawScreen(_g);
		GUI.renderComp(_g, comp);
	}

	protected void tick() {

	}

	private void drawScreen(Graphics _g) {
		_g.setColor(new Color(0xff00ff));
		_g.fillRect(0, 0, Screen.getGameWidth(), Screen.getGameHeight());
	}

}
