package trinkets;

import model.Character;
import model.Trinket;
import model.WeaponSlot;

public class DarkMatter extends Trinket {
	// B725
	public double critChance(Character character) {
		// TODO: EXPAND
		return 13.33;
	}

	// B684
	public double uptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	static public double critChance(Character character, WeaponSlot hand) {
		return (new DarkMatter()).averageCritChance(character, hand);
	}
}
