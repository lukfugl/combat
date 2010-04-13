package trinkets;

import model.Character;
import model.Trinket;
import model.Weapon;

public class DeathsVerdict extends Trinket {
	// B731
	@Override
	public double critChance(Character character) {
		// TODO: EXPAND
		return 5.94;
	}

	// B686
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}

	static public double critChance(Character character, Weapon weapon) {
		return (new DeathsVerdict()).averageCritChance(character, weapon);
	}
}
