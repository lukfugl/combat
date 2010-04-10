package model;

import trinkets.DarkMatter;
import trinkets.DarkmoonCardGreatness;
import trinkets.DeathbringersWill;
import trinkets.DeathsVerdict;
import trinkets.HeroicDeathbringersWill;
import trinkets.HeroicDeathsVerdict;

public abstract class WeaponSlot {
	public Weapon weapon;

	public WeaponSlot(Weapon weapon) {
		this.weapon = weapon;
	}

	public double physicalDPS(Character character) {
		return character.ferociousInspiration() * rawPhysicalDPS(character);
	}

	public double rawPhysicalDPS(Character character) {
		return whiteDPS(character) * averageMitigation(character)
				* character.bloodFrenzy() * character.hysteria();
	}

	public double whiteDPS(Character character) {
		return baseDamage(character) * whiteMultiplier(character)
				* whiteAttacksPerSecond(character)
				* (1 + 0.2 * KillingSpree.uptime());
	}

	public double baseDamage(Character character) {
		return weapon.speed * (weapon.dps + character.attackPower() / 14);
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
		return Math.max(6.5 - 0.25 * character.expertise(this.weapon), 0);
	}

	public double whiteCritChance(Character character) {
		return baseWhiteCritChance(character)
				+ whiteCritChanceFromProcs(character);
	}

	public double baseWhiteCritChance(Character character) {
		return Math.min(character.whiteCritChanceNoAgility(this.weapon)
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

	public double whiteAttacksPerSecond(Character character) {
		return baseAttacksPerSecond(character);
	}

	public double baseAttacksPerSecond(Character character) {
		return character.totalSpeedMultiplier() / weapon.speed;
	}

	public double baseHitsPerSecond(Character character) {
		return baseAttacksPerSecond(character) * whiteHitChance(character);
	}

	public abstract double averageMitigation(Character character);
}