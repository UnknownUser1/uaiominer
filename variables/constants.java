package uaiominer.variables;

import org.rev317.min.api.methods.SceneObjects;

public class constants {
	public static boolean IsLoggedIn() {
		return SceneObjects.getNearest().length > 0;
	}

	public static boolean DroppingOre() {
		return gui.checkBox_Powermine.isSelected();
	}

	public static boolean AutoLogin() {
		return gui.checkBox_Relogin.isSelected();
	}

	public static int[] oreId;

	public static int[] tinOre = { 2094 };
	public static int[] ironOre = { 2092, 2093 };
	public static int[] copperOre = { 2090 };
	public static int[] coalOre = { 2096, 2097 };
	public static int[] silverOre = { 2100 };
	public static int[] goldOre = { 2099, 2098 };
	public static int[] mithrilOre = { 2103, 2102 };
	public static int[] adamantiteOre = { 2104, 2105 };
	public static int[] runeiteOre = { 2107, 2106 };
}
