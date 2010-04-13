package trinkets;

import model.Character;
import model.Trinket;
import model.Weapon;

public class DarkmoonCardGreatness extends Trinket {
	// B728
	@Override
	public double critChance(Character character) {
		// TODO: EXPAND
		return 3.96;
	}

	// B685
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}

	static public double critChance(Character character, Weapon weapon) {
		return (new DarkmoonCardGreatness()).averageCritChance(character,
				weapon);
	}
}
