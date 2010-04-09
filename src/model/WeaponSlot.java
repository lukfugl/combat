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

	public abstract double whiteAttacksPerSecond(Character character);

	public abstract double whiteMultiplier(Character character);

	public abstract double averageMitigation(Character character);
}