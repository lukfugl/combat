package model;

public class Mongoose extends Enchant {
	private Weapon weapon;
	private boolean mainHand;

	public Mongoose(Weapon weapon, boolean mainHand) {
		this.weapon = weapon;
		this.mainHand = mainHand;
	}

	public double baseAgility(Character character) {
		return 120 * character.kings();
	}

	public double baseCritChance(Character character) {
		return character.agilityToCritChance(baseAgility(character));
	}

	// B673/B674
	public double uptime(Character character) {
		// 1 - procChance is the chance it doesn't proc on any given hit.
		// hitsPerSecond * 15 is the number of hits in the preceding 15 seconds.
		// the one raised to the other is the probability of no procs in the
		// preceding 15 seconds. so 1 - that is the probability there was at
		// least one proc in the preceding 15 seconds, and thus that the buff
		// would be active.
		return (1 - Math.pow(1 - procChance(), hitsPerSecond(character) * 15));
	}

	private double hitsPerSecond(Character character) {
		double hitsPerSecond = autoAttackHitsPerSecond(character)
				+ abomHitsPerSecond(character);
		if (mainHand)
			hitsPerSecond += yellowHitsPerSecond(character)
					+ hackAndSlashHitsPerSecond(character);
		return hitsPerSecond;
	}

	// B669
	private double yellowHitsPerSecond(Character character) {
		// TODO: EXPAND
		return 0.48;
	}

	// B670
	private double hackAndSlashHitsPerSecond(Character character) {
		// TODO: EXPAND
		return 0.12;
	}

	// B660/B661
	private double abomHitsPerSecond(Character character) {
		// TODO: EXPAND
		if (mainHand)
			return 0;
		else
			return 0;
	}

	private double procChance() {
		// normalized to average 1 PPM from unhasted auto attacks
		return weapon.speed / 60;
	}

	private double autoAttackSwingsPerSecond(Character character) {
		return passiveSpeedMultiplier(character) / weapon.speed;
	}

	private double autoAttackHitsPerSecond(Character character) {
		return autoAttackSwingsPerSecond(character)
				* character.whiteHitChance(weapon);
	}

	// B552
	private double passiveSpeedMultiplier(Character charater) {
		// TODO: EXPAND
		return 2.19;
	}
}
