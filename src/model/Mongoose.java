package model;

public class Mongoose {
	public static double baseCritChance(Character character) {
		return 120 * 3 / 250.0 * character.kings();
	}

	public static double uptime(Character character, int stacks) {
		// TODO: EXPAND
		switch (stacks) {
		case 0:
			return (double) 1; // B721
		case 1:
			return (double) 0; // B722
		case 2:
			return (double) 0; // B723
		default:
			return (double) 0;
		}
	}

	public static double critChance(Character character, WeaponSlot hand) {
		double chance = 0;
		for (int i = 0; i <= 2; i++)
			chance += critChanceN(character, hand, i) * uptime(character, i);
		return chance;
	}

	public static double critChanceN(Character character, WeaponSlot hand,
			int stacks) {
		return Math.min(stacks * baseCritChance(character), hand
				.critCapRoom(character));
	}
}
