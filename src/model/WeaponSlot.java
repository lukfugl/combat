package model;

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
		return whiteHitChance(character) - 0.06 + 0.01 * whiteCritRate() * (character.whiteCritMultiplier() - 1);
	}

	public double whiteHitChance(Character character) {
		return 0.01 * (100 - dodgeChance() - character.whiteMissChance());
	}

	public abstract double dodgeChance();

	public abstract double whiteCritRate();

	public abstract double whiteAttacksPerSecond(Character character);

	public abstract double averageMitigation(Character character);
}