package model;

import java.util.Collection;
import java.util.ArrayList;
import static literal.collection.List;
import model.Weapon.WeaponType;

public class Race {
	private Collection<WeaponType> favoredWeapons;
	private int expertiseFromFavoredWeapon;

	public Race(Collection<WeaponType> favoredWeapons,
			int expertiseFromFavoredWeapon) {
		this.favoredWeapons = new ArrayList<WeaponType>(favoredWeapons);
		this.expertiseFromFavoredWeapon = expertiseFromFavoredWeapon;
	}

	public int expertise(Weapon weapon) {
		if (favoredWeapons.contains(weapon.type))
			return expertiseFromFavoredWeapon;
		else
			return 0;
	}

	public static final Race Human = new Race(List(WeaponType.Sword,
			WeaponType.Mace), 3);
}
