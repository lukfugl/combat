package model;

public class Mongoose {
	public static double baseCritChance(Character character) {
		return 120 * 3 / 250.0 * character.kings();
	}

	public static double uptime(Character character, int stacks) {
		// TODO: EXPAND
		switch (stacks) {
		case 0:
			return 1; // B721
		case 1:
			return 0; // B722
		case 2:
			return 0; // B723
		default:
			return 0;
		}
	}

	public static double critChance(Character character, Weapon weapon) {
		double chance = 0;
		for (int i = 0; i <= 2; i++)
			chance += critChanceN(character, weapon, i) * uptime(character, i);
		return chance;
	}

	public static double critChanceN(Character character, Weapon weapon,
			int stacks) {
		return Math.min(stacks * baseCritChance(character), weapon
				.critCapRoom(character));
	}
}
