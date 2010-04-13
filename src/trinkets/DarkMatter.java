package trinkets;

import model.Character;
import model.Trinket;
import model.Weapon;

public class DarkMatter extends Trinket {
	// B725
	@Override
	public double critChance(Character character) {
		// TODO: EXPAND
		return 13.33;
	}

	// B684
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}

	static public double critChance(Character character, Weapon weapon) {
		return (new DarkMatter()).averageCritChance(character, weapon);
	}
}
