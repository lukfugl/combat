package model;

public abstract class Trinket implements Proc {
	public abstract double baseCritChance(Character character);
	public abstract double uptime(Character character);
}
