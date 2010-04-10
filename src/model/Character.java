package model;

import model.Weapon.WeaponType;

public class Character {
	private BlackBruise blackBruise;
	private BlackBruise heroicBlackBruise;
	WeaponSlot mainHand;
	WeaponSlot offHand;
	Race race;

	public Character() {
		blackBruise = new BlackBruise(false);
		heroicBlackBruise = new BlackBruise(true);

		// B44/B46
		mainHand = new MainHand(new Weapon(2.6, 205.58, WeaponType.Axe));
		// B45/B47
		offHand = new OffHand(new Weapon(1.5, 178.67, WeaponType.Sword));

		race = Race.Human;
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
		return mainHand.autoAttackDPS(this) + offHand.autoAttackDPS(this)
				+ ruptureDPS() + hackAndSlashDPS() + sinisterStrikeDPS()
				+ eviscerateDPS() + KillingSpree.dps(this)
				+ TinyAbomination.dps(this);
	}

	// B7
	public int expertiseRatingFromGear() {
		return 132;
	}

	// WeaponExpertise
	public int weaponExpertise() {
		return 2;
	}

	public double expertise(Weapon weapon) {
		return expertiseRatingFromGear() * 4 / 32.78998947 + weaponExpertise()
				* 5 + race.expertise(weapon);
	}

	// B75
	public double whiteMissChance() {
		// TODO: EXPAND
		return 9.38;
	}

	// B98
	public double whiteCritChanceFromGear() {
		// TODO: EXPAND
		return 15.51;
	}

	public double whiteCritChanceFromTalents(Weapon weapon) {
		double critChance = malice();
		if (weapon.type == WeaponType.Dagger || weapon.type == WeaponType.Fist)
			critChance += closeQuartersCombat();
		return critChance;
	}

	public double whiteCritChanceFromBuffs() {
		return leaderOfThePack() + heartOfTheCrusader();
	}

	public double whiteCritChanceNoAgility(Weapon weapon) {
		return whiteCritChanceFromGear() + whiteCritChanceFromBuffs()
				+ whiteCritChanceFromTalents(weapon) - 4.8;
	}

	// B712
	public double whiteCritChanceFromAgility() {
		// TODO: EXPAND
		return 25.04;
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

	// B826
	public double totalSpeedMultiplier() {
		// TODO: EXPAND
		return 2.35;
	}

	public double hackAndSlashSwingsPerSecond() {
		double eligibleHitsPerSecond = 0;
		if (mainHand.weapon.hackAndSlash())
			eligibleHitsPerSecond += mainHand.autoAttackHitsPerSecond(this)
					+ sinisterStrikesPerSecond() + smallRupturesPerSecond()
					+ bigRupturesPerSecond() + smallEvisceratesPerSecond()
					+ bigEvisceratesPerSecond()
					+ KillingSpree.hitsPerSecond(this)
					+ TinyAbomination.mainHandProcs(this);
		if (offHand.weapon.hackAndSlash())
			eligibleHitsPerSecond += offHand.autoAttackHitsPerSecond(this)
					+ KillingSpree.hitsPerSecond(this)
					+ TinyAbomination.offHandProcs(this);
		return 0.01 * hackAndSlash() * eligibleHitsPerSecond;
	}

	public double rawHackAndSlashDPS() {
		return hackAndSlashSwingsPerSecond() * mainHand.baseDamage(this)
				* mainHand.whiteMultiplier(this)
				* (1 + 0.2 * KillingSpree.uptime())
				* mainHand.averageMitigation(this) * bloodFrenzy() * hysteria();
	}

	private double hackAndSlashDPS() {
		return ferociousInspiration() * rawHackAndSlashDPS();
	}

	// B935
	public double bigEvisceratesPerSecond() {
		// TODO: EXPAND
		return (double) 0;
	}

	// B934
	public double smallEvisceratesPerSecond() {
		// TODO: EXPAND
		return 0.06;
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

	// B931
	public double sinisterStrikesPerSecond() {
		// TODO: EXPAND
		return 0.37;
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

	// B933
	public double bigRupturesPerSecond() {
		// TODO: EXPAND
		return (double) 0;
	}

	// B932
	public double smallRupturesPerSecond() {
		// TODO: EXPAND
		return (double) 0;
	}

	private double ruptureDPS() {
		return ferociousInspiration() * ruptureRawDPS();
	}

	public double rawWhiteDPS() {
		return mainHand.rawAutoAttackDPS(this) + offHand.rawAutoAttackDPS(this)
				+ rawHackAndSlashDPS() + rawSinisterStrikeDPS()
				+ rawEviscerateDPS() + KillingSpree.rawDPS(this)
				+ TinyAbomination.rawDPS(this);
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

	// Kings
	public double kings() {
		return 1.1;
	}

	// HotC
	private int heartOfTheCrusader() {
		// TODO: EXPAND
		return 3;
	}

	// LotP
	private int leaderOfThePack() {
		// TODO: EXPAND
		return 5;
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

	// CQC
	public int closeQuartersCombat() {
		// TODO: EXPAND
		return 0;
	}

	// Malice
	public int malice() {
		// TODO: EXPAND
		return 5;
	}

	// SwordSpec
	public int hackAndSlash() {
		// TODO: EXPAND
		return 5;
	}
}
