package trinkets;

import model.Character;
import model.Trinket;
import model.WeaponSlot;

public class HeroicDeathbringersWill extends Trinket {
	// B740
	public double critChance(Character character) {
		// TODO: EXPAND
		return 9.24;
	}

	// B689
	public double uptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	static public double critChance(Character character, WeaponSlot hand) {
		return (new HeroicDeathbringersWill()).averageCritChance(character,
				hand);
	}
}
