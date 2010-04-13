package trinkets;

import model.Character;
import model.Trinket;
import model.Weapon;

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

	static public double critChance(Character character, Weapon weapon) {
		return (new HeroicDeathsVerdict()).averageCritChance(character, weapon);
	}
}
