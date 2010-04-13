package model;

public abstract class Trinket {
	public abstract double critChance(Character character);

	public abstract double uptime(Character character);

	public double cappedCritChance(Character character, Weapon weapon) {
		double chance = 0;
		for (int i = 0; i <= 2; i++)
			chance += Math.min(critChance(character), weapon
					.critCapRoom(character)
					- Mongoose.critChanceN(character, weapon, i))
					* Mongoose.uptime(character, i);
		return chance;
	}

	public double averageCritChance(Character character, Weapon weapon) {
		return cappedCritChance(character, weapon) * uptime(character);
	}
}
