package model;

import stats.ArmorPenetration;

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

	public boolean closeQuartersCombat() {
		return type == WeaponType.Dagger || type == WeaponType.Fist;
	}

	public double baseDamage(Character character) {
		return speed * (dps + character.attackPower() / 14);
	}

	public double autoAttackDPS(Character character, Target target) {
		return character.ferociousInspiration() * rawAutoAttackDPS(character, target);
	}

	public double rawAutoAttackDPS(Character character, Target target) {
		return baseDamage(character) * character.whiteMultiplier(target, this)
				* autoAttackSwingsPerSecond(character)
				* (1 + 0.2 * KillingSpree.uptime())
				* ArmorPenetration.mitigation(character, this)
				* character.bloodFrenzy() * character.hysteria();
	}

	public double autoAttackHitsPerSecond(Character character) {
		return autoAttackSwingsPerSecond(character) * character.whiteHitChance(this);
	}

	public double autoAttackSwingsPerSecond(Character character) {
		return character.totalSpeedMultiplier() / speed;
	}
}
