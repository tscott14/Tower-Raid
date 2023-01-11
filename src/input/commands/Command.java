package input.commands;

import java.util.Scanner;

import entity.Entity;
import entity.mob.Player;

public class Command {

	public static Command command = new Command();

	private static Scanner scan = new Scanner(System.in);
	private boolean hasLoaded = false;

	public Command() {
		Thread thread = new Thread(new Runnable() {

			public void run() {
				while (true) {
					String command = getInput();
					if (command.startsWith("/")) {
						checkCommand(command);
					} else {
						System.out.println(command);
					}
				}
			}

		});
		hasLoaded = true;
		System.out.println("Loaded Command Class");
		thread.start();
	}

	protected void checkCommand(String c) {
		c = c.toLowerCase();
		if (c.equals("/stop")) stopAction();
		if (c.equals("/killall")) killallAction();
		if (c.equals("/killplayer")) killplayerAction();
		if (c.equals("/togglegodmode")) toggleGodmodeAction();

	}

	private void toggleGodmodeAction() {
		System.out.println("Running /toggleGodmode Command... ");
		if (Player.Client.godMode) Player.Client.godMode = false;
		else if (!Player.Client.godMode) Player.Client.godMode = true;
		System.out.print("Successful : Godmode is " + (Player.Client.godMode ? "Active" : "Deactive"));
		System.out.println("");
	}

	private void killplayerAction() {
		Player.Client.kill();
	}

	private void stopAction() {
		System.exit(0);
	}

	private void killallAction() {
		Entity.destroyAllEntities();
	}

	public String getInput() {
		return scan.nextLine();
	}

	public boolean isHasLoaded() {
		return hasLoaded;
	}
}
