package trinkets;

import model.Character;
import model.Trinket;
import model.WeaponSlot;

public class HeroicDeathsVerdict extends Trinket {
	// B734
	public double critChance(Character character) {
		// TODO: EXPAND
		return 6.73;
	}

	// B687
	public double uptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	static public double critChance(Character character, WeaponSlot hand) {
		return (new HeroicDeathsVerdict()).averageCritChance(character, hand);
	}
}
