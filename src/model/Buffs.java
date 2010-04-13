package model;

public class Buffs {
	public boolean leaderOfThePack = true;
	public boolean rampage = true;
	public boolean improvedMarkOfTheWild = true;
	public boolean markOfTheWild = true;
	public boolean improvedStrengthOfEarth = true;
	public boolean strengthOfEarth = true;
	public boolean hornOfWinter = true;

	// The Leader of the Pack (Feral Druid) and Rampage (Fury Warrior) buffs
	// increase critical strike chance by 5%.
	public double meleeCritChanceBuff() {
		if (leaderOfThePack || rampage)
			return 5.0;
		else
			return 0;
	}

	// The Mark of the Wild (Druid) buff increases all stats by 37. If improved,
	// the buff is increased by 40% to 51.
	public int additiveStatBuff() {
		if (improvedMarkOfTheWild)
			return 51;
		else if (markOfTheWild)
			return 37;
		else
			return 0;
	}

	// The Strength of Earth (Shaman) and Horn of Winter (Death Knight) buffs
	// increase strength and agility by 155. If the Strength of Earth is
	// improved, the buff is increased by 15% to 178.
	public int agilityAndStrengthBuff() {
		if (improvedStrengthOfEarth )
			return 178;
		else if (strengthOfEarth  || hornOfWinter )
			return 155;
		else
			return 0;
	}
}
