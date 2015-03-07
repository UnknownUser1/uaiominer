package uaiominer.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;

import uaiominer.Main;
import uaiominer.variables.constants;

public class Relog implements Strategy {

	@Override
	public boolean activate() {
		return !constants.IsLoggedIn() && constants.AutoLogin();
	}

	@Override
	public void execute() {
		Mouse.getInstance().click(380, 288, true);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				Main.reLogged += 1;
				return constants.IsLoggedIn();
			}
		}, 3450);
	}

}
