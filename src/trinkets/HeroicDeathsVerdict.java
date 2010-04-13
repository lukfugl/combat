package trinkets;

import model.Character;
import model.Trinket;

public class HeroicDeathsVerdict extends Trinket {
	// B734
	@Override
	public double baseCritChance(Character character) {
		// TODO: EXPAND
		return 6.73;
	}

	// B687
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}
}
