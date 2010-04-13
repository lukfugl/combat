package trinkets;

import model.Character;
import model.Trinket;

public class DeathsVerdict extends Trinket {
	// B731
	@Override
	public double baseCritChance(Character character) {
		// TODO: EXPAND
		return 5.94;
	}

	// B686
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}
}
