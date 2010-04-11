package abilities;

import stats.ArmorPenetration;
import model.Character;

public class Eviscerate {
	public static double dps(Character character) {
		return character.ferociousInspiration() * rawDPS(character);
	}

	// ... * B971
	public static double rawDPS(Character character) {
		// TODO: EXPAND
		return ArmorPenetration
				.mitigation(character, character.mainHand.weapon)
				* character.bloodFrenzy() * character.hysteria() * 752;
	}

	// B934
	public static double littleHitsPerSecond(Character character) {
		// TODO: EXPAND
		return 0.06;
	}

	// B935
	public static double bigHitsPerSecond(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}
}
