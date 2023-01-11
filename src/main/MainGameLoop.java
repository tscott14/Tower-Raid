package main;

import graphics.Game;
import input.commands.Command;

public class MainGameLoop {

	public static int w = 1080, h = 800;

	public MainGameLoop() {
		Game game = new Game(w, h, "Beta: 0.1.0");
		Command.command.isHasLoaded();
		game.start();

	}

	public static void main(String[] args) {
		new MainGameLoop();
	}

}
