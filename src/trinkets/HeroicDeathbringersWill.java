package trinkets;

import model.Character;
import model.Trinket;
import model.Weapon;

public class HeroicDeathbringersWill extends Trinket {
	// B740
	@Override
	public double critChance(Character character) {
		// TODO: EXPAND
		return 9.24;
	}

	// B689
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}

	static public double critChance(Character character, Weapon weapon) {
		return (new HeroicDeathbringersWill()).averageCritChance(character,
				weapon);
	}
}
