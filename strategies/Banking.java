package uaiominer.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

import uaiominer.variables.constants;

public class Banking implements Strategy {

	SceneObject[] bank = SceneObjects.getNearest(2213);
	public static int x;
	public static int y;

	@Override
	public boolean activate() {

		return Inventory.isFull() && !constants.DroppingOre()
				&& constants.IsLoggedIn()
				&& Players.getMyPlayer().getAnimation() == -1;
	}

	@Override
	public void execute() {
		if (Game.getOpenInterfaceId() == 5292) {
			Menu.sendAction(646, 2609, 58, 21012);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Inventory.isEmpty();
				}
			}, 3450);
			Menu.sendAction(200, 8, 51, 5384);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Game.getOpenBackDialogId() == -1;
				}
			}, 3450);
			Menu.sendAction(315, 36257792, 55, 1541);
			Time.sleep(1250);
			Menu.sendAction(315, 22, 390, 2498);
			Time.sleep(1250);
			Menu.sendAction(315, 347, 0, 2494);
			Time.sleep(1250);
			Mouse.getInstance().click(x, y, true);
			Time.sleep(1250);
		} else {
			Keyboard.getInstance().sendKeys("::home");
			Time.sleep(3450);
		}
		if (bank.length > 0 && bank != null && bank[0].distanceTo() < 20
				&& Game.getOpenInterfaceId() == -1 && bank != null) {
			bank[0].interact(1);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Game.getOpenInterfaceId() != -1;
				}

			}, 3450);
		}
	}
}
