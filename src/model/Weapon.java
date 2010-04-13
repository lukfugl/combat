package model;

import stats.ArmorPenetration;
import trinkets.DarkMatter;
import trinkets.DarkmoonCardGreatness;
import trinkets.DeathbringersWill;
import trinkets.DeathsVerdict;
import trinkets.HeroicDeathbringersWill;
import trinkets.HeroicDeathsVerdict;

public class Weapon {
	public enum WeaponType {
		Sword, Mace, Axe, Fist, Dagger, Other
	}

	public double speed;
	public double dps;
	public WeaponType type;

	public Weapon(double speed, double dps, WeaponType type) {
		this.speed = speed;
		this.dps = dps;
		this.type = type;
	}

	public boolean hackAndSlash() {
		return type == WeaponType.Sword || type == WeaponType.Axe;
	}

	public double autoAttackDPS(Character character) {
		return character.ferociousInspiration() * rawAutoAttackDPS(character);
	}

	public double rawAutoAttackDPS(Character character) {
		return baseDamage(character) * whiteMultiplier(character)
				* autoAttackSwingsPerSecond(character)
				* (1 + 0.2 * KillingSpree.uptime())
				* ArmorPenetration.mitigation(character, this)
				* character.bloodFrenzy() * character.hysteria();
	}

	public double baseDamage(Character character) {
		return speed * (dps + character.attackPower() / 14);
	}

	public double whiteMultiplier(Character character) {
		return whiteHitChance(character) - 0.06 + 0.01
				* whiteCritChance(character)
				* (character.whiteCritMultiplier() - 1);
	}

	public double whiteHitChance(Character character) {
		return 0.01 * (100 - dodgeChance(character) - character
				.whiteMissChance());
	}

	public double dodgeChance(Character character) {
		return Math.max(6.5 - 0.25 * character.expertise(this), 0);
	}

	public double whiteCritChance(Character character) {
		return baseWhiteCritChance(character)
				+ whiteCritChanceFromProcs(character);
	}

	public double baseWhiteCritChance(Character character) {
		return Math.min(character.whiteCritChanceNoAgility(this)
				+ character.whiteCritChanceFromAgility(),
				whiteCritCap(character));
	}

	public double whiteCritCap(Character character) {
		return 100 * whiteHitChance(character) - 24;
	}

	public double critCapRoom(Character character) {
		return whiteCritCap(character) - baseWhiteCritChance(character);
	}

	public double whiteCritChanceFromProcs(Character character) {
		return DarkMatter.critChance(character, this)
				+ DarkmoonCardGreatness.critChance(character, this)
				+ DeathsVerdict.critChance(character, this)
				+ HeroicDeathsVerdict.critChance(character, this)
				+ DeathbringersWill.critChance(character, this)
				+ HeroicDeathbringersWill.critChance(character, this)
				+ Mongoose.critChance(character, this);
	}

	public double autoAttackSwingsPerSecond(Character character) {
		return character.totalSpeedMultiplier() / speed;
	}

	public double autoAttackHitsPerSecond(Character character) {
		return autoAttackSwingsPerSecond(character) * whiteHitChance(character);
	}
}
