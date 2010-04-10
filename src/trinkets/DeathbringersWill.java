package trinkets;

import model.Character;
import model.Trinket;
import model.WeaponSlot;

public class DeathbringersWill extends Trinket {
	// B737
	public double critChance(Character character) {
		// TODO: EXPAND
		return 7.92;
	}

	// B688
	public double uptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	static public double critChance(Character character, WeaponSlot hand) {
		return (new DeathbringersWill()).averageCritChance(character, hand);
	}
}
