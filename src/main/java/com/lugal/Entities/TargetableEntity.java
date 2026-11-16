package com.lugal.Entities;

import com.lugal.Enums.AppliedStatusEnum;
import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Enums.StatModEnum;
import com.lugal.Enums.StatusResistanceEnum;

public interface TargetableEntity {
    
    String getName();
    int getLevel();

    int getCurrentStat(StatEnum stat);
    int getMaxStat(StatEnum stat);

    void modifyStat(StatEnum stat, int amount);

    int getEffectiveStat(StatEnum stat);

    void applyStatus(AppliedStatusEnum status, Integer duration);
    int getStatusIntensity(AppliedStatusEnum status);
    float getStatusModTotal(AppliedStatusEnum status);

    void applyStatMod(StatModEnum status, Integer duration);
    int getStatModIntensity(StatModEnum status);
    float getStatModTotal(StatModEnum status);

    float getElementResistances(ElementEnum element);
    float getStatusResistances(StatusResistanceEnum status);

    boolean hasStatModification(StatModEnum status);
    boolean hasStatus(AppliedStatusEnum status);

    void resetTurnStates();

}