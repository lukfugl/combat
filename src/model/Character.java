package model;

import java.util.List;

import trinkets.DarkMatter;
import trinkets.DarkmoonCardGreatness;
import trinkets.DeathbringersWill;
import trinkets.DeathsVerdict;
import trinkets.HeroicDeathbringersWill;
import trinkets.HeroicDeathsVerdict;
import abilities.Eviscerate;
import abilities.HackAndSlash;
import abilities.Rupture;
import abilities.SinisterStrike;
import model.Weapon.WeaponType;
import static literal.collection.List;

public class Character {
	public Gear gear;
	public Talents talents;
	public Weapon mainHand;
	public Weapon offHand;
	Race race;

	private BlackBruise blackBruise;
	private BlackBruise heroicBlackBruise;
	private Proc darkMatter;
	private Proc darkmoonCardGreatness;
	private Proc deathbringersWill;
	private Proc heroicDeathbringersWill;
	private Proc deathsVerdict;
	private Proc heroicDeathsVerdict;
	private Proc mainHandMongoose;
	private Proc offHandMongoose;
	private Buffs buffs;

	public Character() {
		gear = new Gear();
		gear.expertiseRating = 132; // B7 TODO:EXPAND
		gear.hit = 381; // B6 TODO:EXPAND
		gear.critRating = 712; // B5 TODO:EXPAND
		gear.armorPenetration = 468; // B9 TODO:EXPAND
		gear.agility = 1496; // B3 TODO:EXPAND

		// B44/B46
		mainHand = new Weapon(2.6, 205.58, WeaponType.Axe);
		// B45/B47
		offHand = new Weapon(1.5, 178.67, WeaponType.Sword);

		talents = new Talents();
		talents.dualWieldSpecialization = 5; // DWSpec TODO:EXPAND
		talents.closeQuartersCombat = 0; // CQC TODO:EXPAND
		talents.malice = 5; // Malice TODO:EXPAND
		talents.hackAndSlash = 5; // SwordSpec TODO:EXPAND
		talents.maceSpecialization = 0; // MaceSpec TODO:EXPAND
		talents.precision = 5; // Precision TODO:EXPAND
		talents.weaponExpertise = 2; // WeaponExpertise TODO:EXPAND

		blackBruise = new BlackBruise(false);
		heroicBlackBruise = new BlackBruise(true);
		darkMatter = new DarkMatter();
		darkmoonCardGreatness = new DarkmoonCardGreatness();
		deathbringersWill = new DeathbringersWill();
		heroicDeathbringersWill = new HeroicDeathbringersWill();
		deathsVerdict = new DeathsVerdict();
		heroicDeathsVerdict = new HeroicDeathsVerdict();
		mainHandMongoose = new Mongoose(mainHand, true);
		offHandMongoose = new Mongoose(offHand, false);

		buffs = new Buffs();

		race = Race.Human;
	}

	// B1083
	public double dps(Target target) {
		return physicalDPS(target) + magicalDPS(target);
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

	private double physicalDPS(Target target) {
		return mainHand.autoAttackDPS(this, target)
				+ offHand.autoAttackDPS(this, target) * offHandPenalty()
				+ Rupture.dps(this) + HackAndSlash.dps(this, target)
				+ SinisterStrike.dps(this) + Eviscerate.dps(this)
				+ KillingSpree.dps(this) + TinyAbomination.dps(this);
	}

	public double offHandPenalty() {
		return 0.5 + 0.05 * talents.dualWieldSpecialization;
	}

	// B75
	public double whiteMissChance() {
		return Math.max(27 - heroicPresence() - talents.precision - gear.hit
				/ 32.78998947, 0);
	}

	public double staticAgility() {
		return (race.agility() + gear.agility + buffs.additiveStatBuff() + buffs
				.agilityAndStrengthBuff())
				* kings();
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

	public double rawWhiteDPS(Target target) {
		return mainHand.rawAutoAttackDPS(this, target)
				+ offHand.rawAutoAttackDPS(this, target) * offHandPenalty()
				+ HackAndSlash.rawDPS(this, target)
				+ SinisterStrike.rawDPS(this) + Eviscerate.rawDPS(this)
				+ KillingSpree.rawDPS(this) + TinyAbomination.rawDPS(this);
	}

	// B990
	private double rawPoisonDPS() {
		// TODO: EXPAND
		return 2491.97;
	}

	// Kings
	public double kings() {
		// TODO: EXPAND
		return 1.1;
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

	// HeroicPresence
	public double heroicPresence() {
		// TODO: EXPAND
		return 1.0;
	}

	public double expertise(Weapon weapon) {
		return expertiseRatingToExpertise(gear.expertiseRating)
				+ talents.weaponExpertise * 5 + race.expertise(weapon);
	}

	// 
	public double staticCritChance(Target target, Weapon weapon) {
		// Rogue's start with an initial -0.295% chance to crit before adding in
		// critical strike chance from agility and crit rating. This depression shows up after 
		double critChance = -0.295 - 4.8;
		critChance += critRatingToCritChance(gear.critRating)
				+ agilityToCritChance(staticAgility())
				+ buffs.meleeCritChanceBuff()
				+ target.debuffs.critChanceDebuff() + talents.malice;
		if (weapon.closeQuartersCombat())
			critChance += talents.closeQuartersCombat;
		return critChance;
	}

	public double critChanceFromProcs(Weapon weapon) {
		List<Proc> critChanceProcs = List(darkMatter, darkmoonCardGreatness,
				deathsVerdict, heroicDeathsVerdict, deathbringersWill,
				heroicDeathbringersWill, mainHandMongoose, offHandMongoose);
		double averageCritChance = 0;
		for (Proc proc : critChanceProcs)
			averageCritChance += proc.baseCritChance(this) * proc.uptime(this);
		return averageCritChance;
	}

	public double critChance(Target target, Weapon weapon) {
		return staticCritChance(target, weapon) + critChanceFromProcs(weapon);
	}

	public double whiteCritCap(Weapon weapon) {
		return 100 * whiteHitChance(weapon) - 24;
	}

	public double whiteHitChance(Weapon weapon) {
		return 0.01 * (100 - dodgeChance(weapon) - whiteMissChance());
	}

	public double dodgeChance(Weapon weapon) {
		return Math.max(6.5 - 0.25 * expertise(weapon), 0);
	}

	public double staticWhiteCritChance(Target target, Weapon weapon) {
		return Math.min(staticCritChance(target, weapon), whiteCritCap(weapon));
	}

	public double whiteCritChanceFromProcs(Target target, Weapon weapon) {
		// sum of capped crit chance for each combination, weighted by uptime
		List<Proc> critChanceProcs = List(darkMatter, darkmoonCardGreatness,
				deathsVerdict, heroicDeathsVerdict, deathbringersWill,
				heroicDeathbringersWill, mainHandMongoose, offHandMongoose);
		int combinationCount = (int) Math.pow(2, critChanceProcs.size());
		double averageCritChance = 0;
		double cap = whiteCritCap(weapon)
				- staticWhiteCritChance(target, weapon);
		for (int i = 0; i < combinationCount; i++) {
			double uptime = 1;
			double critChance = 0;
			for (int j = 0; j < critChanceProcs.size(); j++) {
				Proc proc = critChanceProcs.get(j);
				if (i >> j % 2 == 1) {
					// proc included
					uptime *= proc.uptime(this);
					critChance += proc.baseCritChance(this);
				} else {
					// proc excluded
					uptime *= 1 - proc.uptime(this);
				}
			}
			averageCritChance += Math.min(critChance, cap) * uptime;
		}
		return averageCritChance;
	}

	public double whiteCritChance(Target target, Weapon weapon) {
		return staticWhiteCritChance(target, weapon)
				+ whiteCritChanceFromProcs(target, weapon);
	}

	public double whiteMultiplier(Target target, Weapon weapon) {
		return whiteHitChance(weapon) - 0.06 + 0.01
				* whiteCritChance(target, weapon) * (whiteCritMultiplier() - 1);
	}

	// conversions
	public double agilityToCritChance(double agility) {
		return 3 * agility / 250.0;
	}

	public double expertiseRatingToExpertise(int expertiseRating) {
		return 4 * expertiseRating / 32.78998947;
	}

	public double critRatingToCritChance(int critRating) {
		return critRating / 45.90598679;
	}
}
