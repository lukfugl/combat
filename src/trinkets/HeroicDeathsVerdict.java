package trinkets;

import model.Character;
import model.Trinket;
import model.WeaponSlot;

public class HeroicDeathsVerdict extends Trinket {
	// B734
	@Override
	public double critChance(Character character) {
		// TODO: EXPAND
		return 6.73;
	}

	// B687
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}

	static public double critChance(Character character, WeaponSlot hand) {
		return (new HeroicDeathsVerdict()).averageCritChance(character, hand);
	}
}
