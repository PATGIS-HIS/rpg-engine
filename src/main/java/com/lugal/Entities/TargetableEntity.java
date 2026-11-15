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
    void modifyStat(StatEnum stat, int amount);
    void applyStatDelta(StatEnum stat, int delta);
    int getEffectiveStat(StatEnum stat);
    void clearStatDelta(StatEnum stat);

    void applyStatus(AppliedStatusEnum status, Integer duration);

    float getElementResistances(ElementEnum element);
    float getStatusReistances(StatusResistanceEnum status);

    boolean hasStatModification(StatModEnum status);
    boolean hasStatus(AppliedStatusEnum status);

    void setDefending(boolean defending);
    boolean isDefending();
    void resetTurnStates();

    
}