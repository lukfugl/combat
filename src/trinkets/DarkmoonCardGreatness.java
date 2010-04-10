package trinkets;

import model.Character;
import model.Trinket;
import model.WeaponSlot;

public class DarkmoonCardGreatness extends Trinket {
	// B728
	public double critChance(Character character) {
		// TODO: EXPAND
		return 3.96;
	}

	// B685
	public double uptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	static public double critChance(Character character, WeaponSlot hand) {
		return (new DarkmoonCardGreatness()).averageCritChance(character, hand);
	}
}
