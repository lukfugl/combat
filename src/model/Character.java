package model;

import abilities.Eviscerate;
import abilities.HackAndSlash;
import abilities.Rupture;
import abilities.SinisterStrike;
import model.Weapon.WeaponType;

public class Character {
	private BlackBruise blackBruise;
	private BlackBruise heroicBlackBruise;
	public WeaponSlot mainHand;
	public WeaponSlot offHand;
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
				+ Rupture.dps(this) + HackAndSlash.dps(this)
				+ SinisterStrike.dps(this) + Eviscerate.dps(this)
				+ KillingSpree.dps(this) + TinyAbomination.dps(this);
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

	public double rawWhiteDPS() {
		return mainHand.rawAutoAttackDPS(this) + offHand.rawAutoAttackDPS(this)
				+ HackAndSlash.rawDPS(this) + SinisterStrike.rawDPS(this)
				+ Eviscerate.rawDPS(this) + KillingSpree.rawDPS(this)
				+ TinyAbomination.rawDPS(this);
	}

	// B990
	private double rawPoisonDPS() {
		// TODO: EXPAND
		return 2491.97;
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

	// MaceSpec
	public int MaceSpecialization() {
		// TODO: EXPAND
		return 0;
	}
}
