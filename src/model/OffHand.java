package model;

public class OffHand extends WeaponSlot {
	public OffHand(Weapon weapon) {
		super(weapon);
	}
	
	// B947
	public double baseDamage(Character character) {
		return super.baseDamage(character) * offHandPenalty(character);
	}

	public double offHandPenalty(Character character) {
		return 0.5 + 0.05 * character.dualWieldSpecialization();
	}

	// B928
	public double whiteAttacksPerSecond(Character character) {
		// TODO: EXPAND
		return 1.57;
	}

	// B948
	public double whiteMultiplier(Character character) {
		// TODO: EXPAND
		return 1.56;
	}

	// B1073
	public double averageMitigation(Character character) {
		// TODO: EXPAND
		return 0.74;
	}
}
