package model;

import stats.ArmorPenetration;

public class TinyAbomination {

	public static double dps(Character character) {
		return character.ferociousInspiration() * rawDPS(character);
	}

	public static double rawDPS(Character character) {
		return mainHandDPS(character) + offHandDPS(character);
	}

	// B929
	public static double mainHandProcs(Character character) {
		// TODO: EXPAND
		return 0;
	}

	// B930
	public static double offHandProcs(Character character) {
		// TODO: EXPAND
		return 0;
	}

	// B953 * ...
	private static double mainHandDPS(Character character) {
		// TODO: EXPAND
		return (0) * ArmorPenetration.mitigation(character, character.mainHand)
				* character.bloodFrenzy() * character.hysteria();
	}

	// B957 * ...
	private static double offHandDPS(Character character) {
		// TODO: EXPAND
		return (0) * ArmorPenetration.mitigation(character, character.offHand)
				* character.bloodFrenzy() * character.hysteria();
	}
}
