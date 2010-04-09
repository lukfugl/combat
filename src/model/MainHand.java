package model;

public class MainHand extends WeaponSlot {
	public MainHand(Weapon weapon) {
		super(weapon);
	}
	
	// B927
	public double whiteAttacksPerSecond(Character character) {
		// TODO: EXPAND
		return 1.03;
	}

	// B944
	public double whiteMultiplier(Character character) {
		// TODO: EXPAND
		return 1.59;
	}

	// B1052
	public double averageMitigation(Character character) {
		// TODO: EXPAND
		return 0.75;
	}
}
