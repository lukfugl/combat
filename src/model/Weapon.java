package model;

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
}
