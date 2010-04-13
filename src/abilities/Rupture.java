package abilities;

import model.Character;

public class Rupture {
	public static double dps(Character character) {
		return character.ferociousInspiration() * rawDPS(character);
	}

	// B1080
	public static double rawDPS(Character character) {
		// TODO: EXPAND
		return 0;
	}

	// B933
	public static double bigHitsPerSecond(Character character) {
		// TODO: EXPAND
		return 0;
	}

	// B932
	public static double littleHitsPerSecond(Character character) {
		// TODO: EXPAND
		return 0;
	}
}
