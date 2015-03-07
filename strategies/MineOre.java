package uaiominer.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

import uaiominer.variables.constants;

public class MineOre implements Strategy {

	public static int[] oreToMine = constants.oreId;

	public boolean activate() {

		return !Inventory.isFull()
				&& Players.getMyPlayer().getAnimation() == -1
				&& constants.IsLoggedIn();
	}

	public void execute() {
		SceneObject[] mineId = SceneObjects.getNearest(oreToMine);
		if (mineId.length > 0 && mineId != null && mineId[0].distanceTo() > 0) {
			mineId[0].interact(1);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getAnimation() != -1;
				}
			}, 1450);
		}
	}
}
