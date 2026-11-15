package com.lugal.Entities;

import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Enums.StatusEnum;

public interface TargetableEntity {
    
    String getName();

    int getCurrentStat(StatEnum stat);
    int getMaxStat(StatEnum stat);
    void modifyStat(StatEnum stat, int amount);
    void applyStatDelta(StatEnum stat, int delta);
    int getEffectiveStat(StatEnum stat);
    void clearStatDelta(StatEnum stat);

    void applyStatus(StatusEnum status, Integer duration);

    float getElementResistances(ElementEnum element);
    float getStatusReistances(StatusEnum status);

    void setDefending(boolean defending);
    boolean isDefending();
    void resetTurnStates();

    
}