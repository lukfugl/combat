package model;

public class BlackBruise {
	private boolean heroic;

	public BlackBruise(boolean heroic) {
		this.heroic = heroic;
	}

	public double uptime(Character character) {
		if (heroic) {
			// TODO: EXPAND
			// B1076
			return (double) 0;
		} else {
			// TODO: EXPAND
			// B1075
			return (double) 0;
		}
	}

	private double multiplier() {
		// Black Bruise adds 9% of white damage as shadow damage. This is
		// increased to 10% in the heroic version.
		if (heroic) {
			return 0.10;
		} else {
			return 0.09;
		}
	}

	public double magicalDPS(Character character, Target target) {
		return character.ferociousInspiration() * target.magicSuppression()
				* multiplier() * uptime(character) * character.rawWhiteDPS();
	}
}
