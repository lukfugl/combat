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
}
