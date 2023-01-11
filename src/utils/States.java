package utils;

public class States {
	private static boolean Game, StartMenu, options;

	public static boolean isInGame() {
		return Game;
	}

	public static void setInGame() {
		options = false;
		StartMenu = false;
		Game = true;
	}

	public static boolean isInOptions() {
		return options;
	}

	public static void setInOptions() {
		StartMenu = false;
		Game = false;
		options = true;
	}

	public static boolean isInStartMenu() {
		return StartMenu;
	}

	public static void setInStartMenu() {
		options = false;
		Game = false;
		StartMenu = true;
	}

}
