package trinkets;

import model.Character;
import model.Trinket;
import model.Weapon;

public class DeathbringersWill extends Trinket {
	// B737
	@Override
	public double critChance(Character character) {
		// TODO: EXPAND
		return 7.92;
	}

	// B688
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}

	static public double critChance(Character character, Weapon weapon) {
		return (new DeathbringersWill()).averageCritChance(character, weapon);
	}
}
