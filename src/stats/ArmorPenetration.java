package stats;

import trinkets.GrimToll;
import trinkets.MjolnirRunestone;
import trinkets.NeedleEncrustedScorpion;
import model.Character;
import model.Weapon;
import model.Weapon.WeaponType;

public class ArmorPenetration {
	private static final double B121 = 8088.68;
	private static final double B122 = 7773.73;
	// B1047
	public static double allProcsUptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	// B1046
	public static double runestoneAndScorpionUptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	// B1045
	public static double grimTollAndScorpionUptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	// B1044
	public static double grimTollAndRunestoneUptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	// B1043
	public static double scorpionOnlyUptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	// B1042
	public static double runestoneOnlyUptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	// B1041
	public static double grimTollOnlyUptime(Character character) {
		// TODO: EXPAND
		return (double) 0;
	}

	// B1040
	public static double noProcsUptime(Character character) {
		// TODO: EXPAND
		return (double) 1;
	}

	// B73/B9
	public static int armorPenetrationFromGear() {
		return 468;
	}

	public static double allProcsMitigation(Character character, Weapon weapon) {
		return mitigationFromArmorPenetration(character, weapon,
				armorPenetrationFromGear() + GrimToll.armorPenetration()
						+ MjolnirRunestone.armorPenetration()
						+ NeedleEncrustedScorpion.armorPenetration());
	}

	public static double runestoneAndScorpionMitigation(Character character,
			Weapon weapon) {
		return mitigationFromArmorPenetration(character, weapon,
				armorPenetrationFromGear()
						+ MjolnirRunestone.armorPenetration()
						+ NeedleEncrustedScorpion.armorPenetration());
	}

	public static double grimTollAndScorpionMitigation(Character character,
			Weapon weapon) {
		return mitigationFromArmorPenetration(character, weapon,
				armorPenetrationFromGear() + GrimToll.armorPenetration()
						+ NeedleEncrustedScorpion.armorPenetration());
	}

	public static double grimTollAndRunestoneMitigation(Character character,
			Weapon weapon) {
		return mitigationFromArmorPenetration(character, weapon,
				armorPenetrationFromGear() + GrimToll.armorPenetration()
						+ MjolnirRunestone.armorPenetration());
	}

	public static double scorpionOnlyMitigation(Character character,
			Weapon weapon) {
		return mitigationFromArmorPenetration(character, weapon,
				armorPenetrationFromGear()
						+ NeedleEncrustedScorpion.armorPenetration());
	}

	public static double runestoneOnlyMitigation(Character character,
			Weapon weapon) {
		return mitigationFromArmorPenetration(character, weapon,
				armorPenetrationFromGear()
						+ MjolnirRunestone.armorPenetration());
	}

	public static double grimTollOnlyMitigation(Character character,
			Weapon weapon) {
		return mitigationFromArmorPenetration(character, weapon,
				armorPenetrationFromGear() + GrimToll.armorPenetration());
	}

	public static double noProcsMitigation(Character character, Weapon weapon) {
		return mitigationFromArmorPenetration(character, weapon,
				armorPenetrationFromGear());
	}

	// B1073
	public static double mitigation(Character character, Weapon weapon) {
		return noProcsMitigation(character, weapon) * noProcsUptime(character)
				+ grimTollOnlyMitigation(character, weapon)
				* grimTollOnlyUptime(character)
				+ runestoneOnlyMitigation(character, weapon)
				* runestoneOnlyUptime(character)
				+ scorpionOnlyMitigation(character, weapon)
				* scorpionOnlyUptime(character)
				+ grimTollAndRunestoneMitigation(character, weapon)
				* grimTollAndRunestoneUptime(character)
				+ grimTollAndScorpionMitigation(character, weapon)
				* grimTollAndScorpionUptime(character)
				+ runestoneAndScorpionMitigation(character, weapon)
				* runestoneAndScorpionUptime(character)
				+ allProcsMitigation(character, weapon)
				* allProcsUptime(character);
	}

	public static double mitigationFromArmorPenetration(Character character,
			Weapon weapon, int armorPenetration) {
		double fractionIgnored = 1.1 * armorPenetration / 1539.529991;
		if (weapon.type == WeaponType.Mace)
			fractionIgnored += 0.03 * character.MaceSpecialization();
		fractionIgnored = Math.min(fractionIgnored, 1.00);
		return 15232.5 / (15232.5 + B121 - fractionIgnored * B122);
	}
}
