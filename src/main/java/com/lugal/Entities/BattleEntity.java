package com.lugal.Entities;

import java.util.EnumMap;
import java.util.Map;

import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Enums.StatusEnum;

public class BattleEntity implements TargetableEntity {

    private final Entity baseEntity;

    private final Map<StatEnum, Integer> currentStats = new EnumMap<>(StatEnum.class);
    private final Map<StatEnum, Integer> maxStats = new EnumMap<>(StatEnum.class);

    private final Map<StatEnum, Integer> statDeltas = new EnumMap<>(StatEnum.class);

    private final Map<StatusEnum, Integer> activeStatuses = new EnumMap<>(StatusEnum.class);

    private boolean isDefending = false;

    public BattleEntity(Entity baseEntity) {
        this.baseEntity = baseEntity;

        maxStats.put(StatEnum.HP, baseEntity.getHp());
        maxStats.put(StatEnum.MP, baseEntity.getMp());
        maxStats.put(StatEnum.ATK, baseEntity.getAtk());
        maxStats.put(StatEnum.STR, baseEntity.getStr());
        maxStats.put(StatEnum.DEF, baseEntity.getDef());
        maxStats.put(StatEnum.RES, baseEntity.getRes());
        maxStats.put(StatEnum.AGI, baseEntity.getAgi());
        maxStats.put(StatEnum.WIS, baseEntity.getWis());
        maxStats.put(StatEnum.LUCK, baseEntity.getLuck());

        currentStats.putAll(maxStats);
    }

    @Override
    public String getName() {
        return baseEntity.getName();
    }

    @Override
    public int getCurrentStat(StatEnum stat) {
        return currentStats.getOrDefault(stat, 0);
    }

    @Override
    public int getMaxStat(StatEnum stat) {
        return maxStats.getOrDefault(stat, 0);
    }

    @Override
    public void modifyStat(StatEnum stat, int amount) {
        int current = getCurrentStat(stat);
        int max = getMaxStat(stat);
        currentStats.put(stat, Math.clamp(current + amount, 0, max));
    }

    @Override
    public void applyStatDelta(StatEnum stat, int delta) {
        int currentDelta = statDeltas.getOrDefault(stat, 0);
        statDeltas.put(stat, currentDelta + delta);
    }

    @Override
    public int getEffectiveStat(StatEnum stat) {
        int base = maxStats.getOrDefault(stat, 0);
        int delta = switch (stat) {
            case ATK, DEF, AGI, WIS -> statDeltas.getOrDefault(stat, 0);
            default -> 0;
        };
        return Math.max(0, base + delta);
    }

    @Override
    public void clearStatDelta(StatEnum stat) {
        statDeltas.put(stat, 0);
    }

    @Override
    public void applyStatus(StatusEnum status, Integer duration) {
        activeStatuses.put(status, duration);
    }

    @Override
    public float getElementResistances(ElementEnum element) {
        return baseEntity.getElementalResistances(element);
    }

    @Override
    public float getStatusReistances(StatusEnum status) {
        return baseEntity.getStatusResistances(status);
    }

    @Override
    public void setDefending(boolean defending) {
        this.isDefending = defending;
    }

    @Override
    public boolean isDefending() {
        return this.isDefending;
    }

    @Override
    public void resetTurnStates() {
        this.isDefending = false;
    }

}
