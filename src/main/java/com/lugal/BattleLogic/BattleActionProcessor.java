package com.lugal.BattleLogic;

import java.util.List;

import com.lugal.Entities.TargetableEntity;
import com.lugal.Enums.AppliedStatusEnum;
import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Utils.Bounds;

public class BattleActionProcessor {

    private static final List<Bounds<Integer, Float>> EVASION_BOUNDS = List.of(
        new Bounds<>(1, 125, 0.015625f),
        new Bounds<>(125, 249, 0.022097f),
        new Bounds<>(250, 374, 0.03125f),
        new Bounds<>(375, 499, 0.044194f),
        new Bounds<>(500, 624, 0.0625f),
        new Bounds<>(625, 749, 0.088388f),
        new Bounds<>(750, 874, 0.125f),
        new Bounds<>(875, 998, 0.176777f),
        new Bounds<>(999, 999, 0.25f)
    );

    public int calculatePhysicalDamage(TargetableEntity caster, TargetableEntity target, ElementEnum element) {

        float atkMod = 1.0f;
        atkMod += (caster.hasStatus(AppliedStatusEnum.MUSTER_STRENGTH) ? 1.5f : 0f);
        atkMod += (caster.hasStatus(AppliedStatusEnum.FOCUS) ? 1.0f : 0f);
        atkMod += (caster.hasStatus(AppliedStatusEnum.EGG_ON) ? 1.0f : 0f);

        int maxDmg = (int) ((caster.getEffectiveStat(StatEnum.ATK) * atkMod
                - target.getEffectiveStat(StatEnum.DEF) / 2f) / 2f);
        int minDmg = (int) ((caster.getEffectiveStat(StatEnum.ATK) * atkMod
                - target.getEffectiveStat(StatEnum.DEF) / 2f) / 4f);

        if (minDmg > maxDmg) {
            minDmg = maxDmg;
        }

        int roll = (int) (minDmg + Math.random() * ((maxDmg - minDmg) + 1));

        float elementResist = 1.0f - target.getElementResistances(element);

        float defenseMultiplier = 1.0f;
        if (target.hasStatus(AppliedStatusEnum.DEFEND)) {
            defenseMultiplier = 0.5f;
        } else if (target.hasStatus(AppliedStatusEnum.DEFENDING_CHAMPION)) {
            defenseMultiplier = 0.1f;
        }

        return Math.max(0, (int) (roll * elementResist * defenseMultiplier));
    }

    public float dodgeChance(TargetableEntity caster, TargetableEntity target) {
        if (caster.hasStatus(AppliedStatusEnum.FOCUS)) {
            return 0f;
        } else if (target.hasStatus(AppliedStatusEnum.DODGY_DANCE)) {
            return 0.5f;
        }
        float base = 1f / 64f;
        int agi = target.getEffectiveStat(StatEnum.AGI);

        float chance = Bounds.getValue(agi, EVASION_BOUNDS, base);

        return chance;
    }
}
