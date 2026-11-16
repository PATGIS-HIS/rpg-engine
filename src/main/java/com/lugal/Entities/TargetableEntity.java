package com.lugal.Entities;

import com.lugal.Enums.AppliedStatusEnum;
import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Enums.StatModEnum;
import com.lugal.Enums.StatusResistanceEnum;

public interface TargetableEntity {
    
    // Getters
    String getName();
    int getLevel();
    int getCurrentStat(StatEnum stat);
    int getMaxStat(StatEnum stat);
    int getEffectiveStat(StatEnum stat);
    float getElementResistances(ElementEnum element);
    float getStatusResistances(StatusResistanceEnum status);

    void modifyStat(StatEnum stat, int amount);

    // Applied statuses
    void applyStatus(AppliedStatusEnum status, Integer duration);
    int getStatusIntensity(AppliedStatusEnum status);
    float getStatusModTotal(AppliedStatusEnum status);
    boolean hasStatus(AppliedStatusEnum status);

    // Stat modifications
    void applyStatMod(StatModEnum status, Integer duration);
    int getStatModIntensity(StatModEnum status);
    float getStatModTotal(StatModEnum status);
    boolean hasStatModification(StatModEnum status);

    void resetTurnStates();

}