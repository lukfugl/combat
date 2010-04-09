package model;

public class Character {
	private BlackBruise blackBruise;
	private BlackBruise heroicBlackBruise;
	WeaponSlot mainHand;
	WeaponSlot offHand;

	public Character() {
		blackBruise = new BlackBruise(false);
		heroicBlackBruise = new BlackBruise(true);
		
		// B44/B46
		mainHand = new MainHand(new Weapon(2.6, 205.58));
		// B45/B47
		offHand = new OffHand(new Weapon(1.5, 178.67));
	}

	// B1083
	public double dps(Target target) {
		return physicalDPS() + magicalDPS(target);
	}

	// ferociousInspiration() * B1081
	private double magicalDPS(Target target) {
		return poisonDPS(target) + blackBruise.magicalDPS(this, target)
				+ heroicBlackBruise.magicalDPS(this, target);
	}

	private double poisonDPS(Target target) {
		return ferociousInspiration() * target.magicSuppression()
				* ebonPlaguebringer() * rawPoisonDPS();
	}

	private double physicalDPS() {
		return mainHand.physicalDPS(this) + offHand.physicalDPS(this)
				+ ruptureDPS() + sinisterStrikeDPS() + eviscerateDPS()
				+ KillingSpree.dps(this) + TinyAbomination.dps(this);
	}

	// B146
	public double whiteCritMultiplier() {
		// TODO: EXPAND
		return 2.47;
	}

	// B786
	public double attackPower() {
		// TODO: EXPAND
		return 7930.01;
	}

	// ... * B971
	private double rawEviscerateDPS() {
		// TODO: EXPAND
		return mainHand.averageMitigation(this) * bloodFrenzy() * hysteria()
				* 752;
	}

	private double eviscerateDPS() {
		return ferociousInspiration() * rawEviscerateDPS();
	}

	// ... * B961
	private double rawSinisterStrikeDPS() {
		// TODO: EXPAND
		return mainHand.averageMitigation(this) * bloodFrenzy() * hysteria()
				* 1983.67;
	}

	private double sinisterStrikeDPS() {
		return ferociousInspiration() * rawSinisterStrikeDPS();
	}

	private double ruptureDPS() {
		return ferociousInspiration() * ruptureRawDPS();
	}

	public double rawWhiteDPS() {
		return mainHand.rawPhysicalDPS(this) + offHand.rawPhysicalDPS(this)
				+ rawSinisterStrikeDPS() + rawEviscerateDPS()
				+ KillingSpree.rawDPS(this) + TinyAbomination.rawDPS(this);
	}

	// B990
	private double rawPoisonDPS() {
		// TODO: EXPAND
		return 2491.97;
	}

	// B1080
	private double ruptureRawDPS() {
		// TODO: EXPAND
		return (double) 0;
	}

	// EbonPlaguebringer
	private double ebonPlaguebringer() {
		// TODO: EXPAND
		return 1.13;
	}

	// Hysteria
	public double hysteria() {
		// TODO: EXPAND
		return 1.0;
	}

	// BloodFrenzy
	public double bloodFrenzy() {
		// TODO: EXPAND
		return 1.04;
	}

	// FI
	public double ferociousInspiration() {
		// TODO: EXPAND
		return 1.03;
	}

	// DWSpec
	public int dualWieldSpecialization() {
		// TODO: EXPAND
		return 5;
	}
}
