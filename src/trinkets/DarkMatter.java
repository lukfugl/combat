package trinkets;

import model.Character;
import model.Trinket;

public class DarkMatter extends Trinket {
	// B725
	@Override
	public double baseCritChance(Character character) {
		// TODO: EXPAND
		return 13.33;
	}

	// B684
	@Override
	public double uptime(Character character) {
		// TODO: EXPAND
		return 0;
	}
}
