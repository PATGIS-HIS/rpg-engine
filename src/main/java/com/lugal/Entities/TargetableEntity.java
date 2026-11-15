package com.lugal.Entities;

import com.lugal.Enums.AppliedStatusEnum;
import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Enums.StatModEnum;
import com.lugal.Enums.StatusResistanceEnum;

public interface TargetableEntity {
    
    String getName();

    int getCurrentStat(StatEnum stat);
    int getMaxStat(StatEnum stat);
    int getEffectiveStat(StatEnum stat);

    void applyStatus(AppliedStatusEnum status, Integer duration);
    void applyStatMod(StatModEnum mod, Integer duration);

    float getElementResistances(ElementEnum element);
    float getStatusResistances(StatusResistanceEnum status);

    boolean hasStatModification(StatModEnum status);
    boolean hasStatus(AppliedStatusEnum status);

    void setDefending(boolean defending);
    boolean isDefending();
    void resetTurnStates();

}