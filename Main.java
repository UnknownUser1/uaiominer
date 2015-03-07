package uaiominer;

import java.util.ArrayList;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;
import uaiominer.strategies.Banking;
import uaiominer.strategies.DropOre;
import uaiominer.strategies.MineOre;
import uaiominer.strategies.Relog;
import uaiominer.variables.gui;

@ScriptManifest(author = "Unknown User", category = Category.MINING, description = "Aio Miner for ikov", name = "UMiner - Aio", servers = { "Ikov" }, version = 1.1D)
public class Main extends Script implements MessageListener {

	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	private static int oreMined;
	public static int reLogged;

	public boolean onExecute() {
		gui GUI = new gui();
		GUI.setVisible(true);
		while (GUI.isVisible()) {
			sleep(20);
		}
		strategies.add(new Banking());
		strategies.add(new MineOre());
		strategies.add(new DropOre());
		strategies.add(new Relog());
		provide(strategies);

		return true;
	}

	public void onFinish() {
		System.out.println("Script Information");
		System.out.println("You Mined A Total Of " + oreMined + " Ores");
		System.out.println("You Relogged  " + reLogged + " Times!");

	}

	public void messageReceived(MessageEvent m) {
		if (m.getMessage().contains("You get some")) {
			oreMined += 1;
		}
	}
}
