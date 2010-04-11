package abilities;

import stats.ArmorPenetration;
import model.KillingSpree;
import model.Character;
import model.TinyAbomination;

public class HackAndSlash {
	public static double swingsPerSecond(Character character) {
		double eligibleHitsPerSecond = 0;
		if (character.mainHand.weapon.hackAndSlash())
			eligibleHitsPerSecond += character.mainHand
					.autoAttackHitsPerSecond(character)
					+ SinisterStrike.hitsPerSecond(character)
					+ Rupture.littleHitsPerSecond(character)
					+ Rupture.bigHitsPerSecond(character)
					+ Eviscerate.littleHitsPerSecond(character)
					+ Eviscerate.bigHitsPerSecond(character)
					+ KillingSpree.hitsPerSecond(character)
					+ TinyAbomination.mainHandProcs(character);
		if (character.offHand.weapon.hackAndSlash())
			eligibleHitsPerSecond += character.offHand
					.autoAttackHitsPerSecond(character)
					+ KillingSpree.hitsPerSecond(character)
					+ TinyAbomination.offHandProcs(character);
		return 0.01 * character.hackAndSlash() * eligibleHitsPerSecond;
	}

	public static double rawDPS(Character character) {
		return swingsPerSecond(character)
				* character.mainHand.baseDamage(character)
				* character.mainHand.whiteMultiplier(character)
				* (1 + 0.2 * KillingSpree.uptime())
				* ArmorPenetration.mitigation(character,
						character.mainHand.weapon) * character.bloodFrenzy()
				* character.hysteria();
	}

	public static double dps(Character character) {
		return character.ferociousInspiration() * rawDPS(character);
	}
}
