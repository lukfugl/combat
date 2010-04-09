package model;

public class MainHand extends WeaponSlot {
	public MainHand(Weapon weapon) {
		super(weapon);
	}

	// B79
	public double dodgeChance() {
		// TODO: EXPAND
		return (double) 0;
	}

	// B778
	public double whiteCritRate() {
		// TODO: EXPAND
		return 48.75;
	}
	
	// B927
	public double whiteAttacksPerSecond(Character character) {
		// TODO: EXPAND
		return 1.04;
	}

	// B1052
	public double averageMitigation(Character character) {
		// TODO: EXPAND
		return 0.74;
	}
}
