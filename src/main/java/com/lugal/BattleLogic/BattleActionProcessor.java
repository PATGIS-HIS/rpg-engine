package com.lugal.BattleLogic;

import java.util.ArrayList;
import java.util.List;

import com.lugal.Entities.TargetableEntity;
import com.lugal.Enums.AppliedStatusEnum;
import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;

public class BattleActionProcessor {
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
            return 0;
        }
        float base = 1f / 64f;

        base = target.hasStatus(AppliedStatusEnum.DODGEY_DANCE) ? .5f : base;

        return chance;
    }
}
