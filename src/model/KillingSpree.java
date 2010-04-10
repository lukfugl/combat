package model;

public abstract class KillingSpree {
	// B941
	public static double uptime() {
		// TODO: EXPAND
		return 0.03;
	}

	public static double dps(Character character) {
		return character.ferociousInspiration() * rawDPS(character);
	}

	public static double rawDPS(Character character) {
		return mainHandDPS(character) + offHandDPS(character);
	}

	// B984 * ...
	private static double mainHandDPS(Character character) {
		// TODO: EXPAND
		return 266.15 * character.mainHand.averageMitigation(character)
				* character.bloodFrenzy() * character.hysteria();
	}

	// B985 * ...
	private static double offHandDPS(Character character) {
		// TODO: EXPAND
		return 171.53 * character.offHand.averageMitigation(character)
				* character.bloodFrenzy() * character.hysteria();
	}

	// B939
	public static double hitsPerSecond(Character character) {
		// TODO: EXPAND
		return 0.07;
	}

}
