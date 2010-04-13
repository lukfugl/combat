package trinkets;

import model.Character;
import model.Trinket;

public class DeathbringersWill extends Trinket {
	// B737
	@Override
	public double baseCritChance(Character character) {
		// TODO: EXPAND
		return 7.92;
	}

	// B688
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}
}
