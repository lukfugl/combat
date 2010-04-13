package model;

import java.util.Collection;
import java.util.ArrayList;
import static literal.collection.List;
import model.Weapon.WeaponType;

public class Race {
	private Collection<WeaponType> favoredWeapons;
	private int expertiseFromFavoredWeapon;
	private int agility;

	public Race(Collection<WeaponType> favoredWeapons,
			int expertiseFromFavoredWeapon, int agility) {
		this.favoredWeapons = new ArrayList<WeaponType>(favoredWeapons);
		this.expertiseFromFavoredWeapon = expertiseFromFavoredWeapon;
		this.agility = agility;
	}

	public int expertise(Weapon weapon) {
		if (favoredWeapons.contains(weapon.type))
			return expertiseFromFavoredWeapon;
		else
			return 0;
	}
	
	public int agility() {
		return agility;
	}

	public static final Race Human = new Race(List(WeaponType.Sword,
			WeaponType.Mace), 3, 189);
}
