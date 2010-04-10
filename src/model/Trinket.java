package model;

public abstract class Trinket {
	public abstract double critChance(Character character);

	public abstract double uptime(Character character);

	public double cappedCritChance(Character character, WeaponSlot hand) {
		double chance = 0;
		for (int i = 0; i <= 2; i++)
			chance += Math.min(critChance(character), hand
					.critCapRoom(character)
					- Mongoose.critChanceN(character, hand, i))
					* Mongoose.uptime(character, i);
		return chance;
	}

	public double averageCritChance(Character character, WeaponSlot hand) {
		return cappedCritChance(character, hand) * uptime(character);
	}
}
