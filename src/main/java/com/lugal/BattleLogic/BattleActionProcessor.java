package com.lugal.BattleLogic;

import com.lugal.Entities.TargetableEntity;
import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;

public class BattleActionProcessor {
    public int calculatePhysicalDamage(TargetableEntity caster, TargetableEntity target, ElementEnum element) {
        float targetResist = 1 - target.getElementResistances(element);
        
        int highRoll = caster.getEffectiveStat(StatEnum.ATK) - target.getEffectiveStat(StatEnum.DEF) / 4; 
        int lowRoll = caster.getEffectiveStat(StatEnum.ATK) - target.getEffectiveStat(StatEnum.DEF) / 2;
        int roll = (int) (lowRoll + Math.random() * ((highRoll - lowRoll) + 1));
        
        return roll;
    }
}
