package abilities;

import stats.ArmorPenetration;
import model.KillingSpree;
import model.Character;
import model.Target;
import model.TinyAbomination;

public class HackAndSlash {
	public static double swingsPerSecond(Character character) {
		double eligibleHitsPerSecond = 0;
		if (character.mainHand.hackAndSlash())
			eligibleHitsPerSecond += character.mainHand
					.autoAttackHitsPerSecond(character)
					+ SinisterStrike.hitsPerSecond(character)
					+ Rupture.littleHitsPerSecond(character)
					+ Rupture.bigHitsPerSecond(character)
					+ Eviscerate.littleHitsPerSecond(character)
					+ Eviscerate.bigHitsPerSecond(character)
					+ KillingSpree.hitsPerSecond(character)
					+ TinyAbomination.mainHandProcs(character);
		if (character.offHand.hackAndSlash())
			eligibleHitsPerSecond += character.offHand
					.autoAttackHitsPerSecond(character)
					+ KillingSpree.hitsPerSecond(character)
					+ TinyAbomination.offHandProcs(character);
		return 0.01 * character.talents.hackAndSlash * eligibleHitsPerSecond;
	}

	public static double rawDPS(Character character, Target target) {
		return swingsPerSecond(character)
				* character.mainHand.baseDamage(character)
				* character.whiteMultiplier(target, character.mainHand)
				* (1 + 0.2 * KillingSpree.uptime())
				* ArmorPenetration.mitigation(character,
						character.mainHand) * character.bloodFrenzy()
				* character.hysteria();
	}

	public static double dps(Character character, Target target) {
		return character.ferociousInspiration() * rawDPS(character, target);
	}
}
