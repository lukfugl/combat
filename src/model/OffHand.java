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

	// B779
	public double whiteCritRate() {
		// TODO: EXPAND
		return 48.75;
	}

	// B928
	public double whiteAttacksPerSecond(Character character) {
		// TODO: EXPAND
		return 1.57;
	}

	// B1073
	public double averageMitigation(Character character) {
		// TODO: EXPAND
		return 0.74;
	}
}
