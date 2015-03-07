package uaiominer.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;

import uaiominer.variables.constants;

public class DropOre implements Strategy {

	@Override
	public boolean activate() {

		return Inventory.isFull() && constants.DroppingOre()
				&& constants.IsLoggedIn()
				&& Players.getMyPlayer().getAnimation() == -1;
	}

	@Override
	public void execute() {
		Keyboard.getInstance().sendKeys("::empty");
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Inventory.isEmpty();
			}
		}, 3450);

	}

}
