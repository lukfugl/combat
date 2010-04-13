package abilities;

import stats.ArmorPenetration;
import model.Character;

public class SinisterStrike {
	public static double dps(Character character) {
		return character.ferociousInspiration() * rawDPS(character);
	}

	// ... * B961
	public static double rawDPS(Character character) {
		// TODO: EXPAND
		return ArmorPenetration
				.mitigation(character, character.mainHand)
				* character.bloodFrenzy() * character.hysteria() * 1983.67;
	}

	// B931
	public static double hitsPerSecond(Character character) {
		// TODO: EXPAND
		return 0.37;
	}
}
