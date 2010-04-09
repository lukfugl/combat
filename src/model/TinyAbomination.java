package model;

public class TinyAbomination {

	public static double dps(Character character) {
		return character.ferociousInspiration() * rawDPS(character);
	}
	
	public static double rawDPS(Character character) {
		return mainHandDPS(character) + offHandDPS(character);
	}

	// B953 * ...
	private static double mainHandDPS(Character character) {
		// TODO: EXPAND
		return ((double) 0)
				* character.mainHand.averageMitigation(character)
				* character.bloodFrenzy() * character.hysteria();
	}
	
	// B957 * ...
	private static double offHandDPS(Character character) {
		// TODO: EXPAND
		return ((double) 0)
				* character.offHand.averageMitigation(character)
				* character.bloodFrenzy() * character.hysteria();
	}
}
