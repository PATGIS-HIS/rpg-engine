package com.lugal.BattleLogic;

import java.util.List;

import com.lugal.Entities.TargetableEntity;
import com.lugal.Enums.AppliedStatusEnum;
import com.lugal.Enums.DamageTypeEnum;
import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Utils.Bounds;

public class BattleActionProcessor {

    private static final List<Bounds<Integer, Float>> EVASION_BOUNDS = List.of(
            new Bounds<>(  1, 125, 0.015625f),
            new Bounds<>(125, 249, 0.022097f),
            new Bounds<>(250, 374, 0.031250f),
            new Bounds<>(375, 499, 0.044194f),
            new Bounds<>(500, 624, 0.062500f),
            new Bounds<>(625, 749, 0.088388f),
            new Bounds<>(750, 874, 0.125000f),
            new Bounds<>(875, 998, 0.176777f),
            new Bounds<>(999, 999, 0.250000f));

    public int calculateDamage(DamageTypeEnum type, TargetableEntity caster, TargetableEntity target,
            ElementEnum element, float baseRoll) {
                float elementResit = 1.0f - target.getElementResistances(element);
                float defenseMultiplier = defense(target);

                float totalDamage = baseRoll * elementResit * defenseMultiplier;
                return Math.max(0, (int) totalDamage);
    }

    public int calculatePhysicalDamage(TargetableEntity caster, TargetableEntity target, ElementEnum element, float mod) {
        float atkMod = 1.0f
                + caster.getStatusModTotal(AppliedStatusEnum.MUSTER_STRENGTH)
                + caster.getStatusModTotal(AppliedStatusEnum.FOCUS)
                + caster.getStatusModTotal(AppliedStatusEnum.EGG_ON);

        float baseDmg = caster.getEffectiveStat(StatEnum.ATK) * atkMod * mod
                - (target.getEffectiveStat(StatEnum.DEF) / 2f);

        int maxDmg = (int) (baseDmg / 2f);
        int minDmg = Math.min((int) (baseDmg / 4f), maxDmg);
        float roll = minDmg + (float)(Math.random() * ((maxDmg - minDmg) + 1));

        // Route through the pipeline
        return calculateDamage(DamageTypeEnum.PHYSICAL, caster, target, element, roll);
    }

    public int calculateMagicalDamage(TargetableEntity caster, TargetableEntity target,
            ElementEnum element, int maxWIS, int[] bound1, int[] bound2) {
        
        float wisRatio = Math.clamp(
                (float) caster.getEffectiveStat(StatEnum.WIS) / (float) maxWIS, 0f, 1f);

        float atkMod = 1.0f + caster.getStatusModTotal(AppliedStatusEnum.CASTER_SUGAR);
        float defMod = target.getStatusModTotal(AppliedStatusEnum.MAGIC_BARRIER)
                + target.getStatusModTotal(AppliedStatusEnum.ANATHEMATISE);

        float netMultiplier = Math.max(0f, atkMod - defMod);

        float minBase = Math.round(bound1[0] + (bound2[0] - bound1[0]) * wisRatio) * netMultiplier;
        float maxBase = Math.round(bound1[1] + (bound2[1] - bound1[1]) * wisRatio) * netMultiplier;
        float roll = (float) (Math.random() * (maxBase - minBase + 1) + minBase);

        // Route through the pipeline
        return calculateDamage(DamageTypeEnum.MAGICAL, caster, target, element, roll);
    }

    public int calculateBreathDamage(TargetableEntity caster, TargetableEntity target,
            ElementEnum element, int[] bounds) {
        
        float atkMod = 1f + caster.getStatusModTotal(AppliedStatusEnum.DEEP_BREATH);
        float defMod = target.getStatusModTotal(AppliedStatusEnum.INSULATLE);
        float netMultiplier = Math.max(0f, atkMod - defMod);

        float min = bounds[0] * netMultiplier;
        float max = bounds[1] * netMultiplier;
        float roll = (float) (Math.random() * (max - min + 1) + min);

        // Route through the pipeline
        return calculateDamage(DamageTypeEnum.BREATH, caster, target, element, roll);
    }

    public float dodgeChance(TargetableEntity caster, TargetableEntity target) {
        if (caster.hasStatus(AppliedStatusEnum.FOCUS)) {
            return 0f;
        } else if (target.hasStatus(AppliedStatusEnum.DODGY_DANCE)) {
            return target.getStatusModTotal(AppliedStatusEnum.DODGY_DANCE);
        }
        float base = 1f / 64f;
        int agi = target.getEffectiveStat(StatEnum.AGI);

        float chance = Bounds.getValue(agi, EVASION_BOUNDS, base);

        return chance;
    }

    private float defense(TargetableEntity target) {
        if (target.hasStatus(AppliedStatusEnum.DEFENDING_CHAMPION)) {
            return target.getStatusModTotal(AppliedStatusEnum.DEFENDING_CHAMPION);
        } else if (target.hasStatus(AppliedStatusEnum.DEFEND)) {
            return target.getStatusModTotal(AppliedStatusEnum.DEFEND);
        }
        return 1.0f;
    }
}
