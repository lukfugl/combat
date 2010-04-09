package model;

public abstract class WeaponSlot {
	public double physicalDPS(Character character) {
		return character.ferociousInspiration() * rawPhysicalDPS(character);
	}

	public double rawPhysicalDPS(Character character) {
		return (whiteDPS(character) + tinyAbominationInAJarDPS(character))
				* averageMitigation(character)
				* character.bloodFrenzy()
				* character.hysteria();
	}

	public double whiteDPS(Character character) {
		return baseDamage(character) * whiteMultiplier(character)
				* whiteAttacksPerSecond(character)
				* (1 + 0.2 * KillingSpree.uptime());
	}

	public abstract double whiteAttacksPerSecond(Character character);

	public abstract double whiteMultiplier(Character character);

	public abstract double baseDamage(Character character);

	public abstract double tinyAbominationInAJarDPS(Character character);

	public abstract double averageMitigation(Character character);
}