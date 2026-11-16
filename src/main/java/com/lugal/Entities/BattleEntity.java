package com.lugal.Entities;

import java.util.EnumMap;
import java.util.Map;

import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Enums.StatModEnum;
import com.lugal.Enums.AppliedStatusEnum;
import com.lugal.Enums.StatusResistanceEnum;
import com.lugal.Records.StatModRecord;
import com.lugal.Records.StatusRecord;

public class BattleEntity implements TargetableEntity {

    private final Entity baseEntity;

    private final Map<StatEnum, Integer> currentStats = new EnumMap<>(StatEnum.class);
    private final Map<StatEnum, Integer> maxStats = new EnumMap<>(StatEnum.class);

    private final Map<AppliedStatusEnum, StatusRecord> activeStatuses = new EnumMap<>(AppliedStatusEnum.class);
    private final Map<StatModEnum, StatModRecord> activeStatMods = new EnumMap<>(StatModEnum.class);

    public BattleEntity(Entity baseEntity) {
        this.baseEntity = baseEntity;

        maxStats.put(StatEnum.HP, baseEntity.getStat(StatEnum.HP));
        maxStats.put(StatEnum.MP, baseEntity.getStat(StatEnum.MP));
        maxStats.put(StatEnum.ATK, baseEntity.getStat(StatEnum.ATK));
        maxStats.put(StatEnum.STR, baseEntity.getStat(StatEnum.STR));
        maxStats.put(StatEnum.DEF, baseEntity.getStat(StatEnum.DEF));
        maxStats.put(StatEnum.RES, baseEntity.getStat(StatEnum.RES));
        maxStats.put(StatEnum.AGI, baseEntity.getStat(StatEnum.AGI));
        maxStats.put(StatEnum.WIS, baseEntity.getStat(StatEnum.WIS));
        maxStats.put(StatEnum.LUCK, baseEntity.getStat(StatEnum.LUCK));

        currentStats.putAll(maxStats);
    }

    // =======
    // Getters
    // =======

    @Override
    public String getName() {
        return baseEntity.getName();
    }

    @Override
    public int getLevel() {
        return baseEntity.getLevel();
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
    public int getEffectiveStat(StatEnum stat) {
        int baseStat = this.getMaxStat(stat);
        float mod = switch (stat) {
            case ATK -> getStatModTotal(StatModEnum.GRITTY_DITTY) + getStatModTotal(StatModEnum.KABLUNT);
            case WIS -> getStatModTotal(StatModEnum.KAPING) + getStatModTotal(StatModEnum.KADIM);
            case DEF -> getStatModTotal(StatModEnum.KABUFF) + getStatModTotal(StatModEnum.KASAP);
            case AGI -> getStatModTotal(StatModEnum.ACCELERATLE) + getStatModTotal(StatModEnum.DECELERATLE);
            default -> 0f;
        };

        return (int) (baseStat * (1f + mod));
    }

    @Override
    public float getElementResistances(ElementEnum element) {
        return baseEntity.getElementalResistances(element);
    }

    @Override
    public float getStatusResistances(StatusResistanceEnum status) {
        return baseEntity.getStatusResistances(status);
    }

    @Override
    public void modifyStat(StatEnum stat, int amount) {
        int current = getCurrentStat(stat);
        int max = getMaxStat(stat);
        currentStats.put(stat, Math.clamp(current + amount, 0, max));
    }

    // ================
    // Applied Statuses
    // ================

    @Override
    public void applyStatus(AppliedStatusEnum status, Integer duration) {
        AppliedStatusEnum canonical = status.getCanonicalStatus();
        StatusRecord existing = activeStatuses.get(canonical);

        int incomingIntensity = status.weight();
        int newIntensity = (existing != null)
                ? Math.min(existing.intensity() + incomingIntensity, canonical.maxIntensity())
                : Math.min(incomingIntensity, canonical.maxIntensity());

        int newDuration = (existing != null)
                ? Math.max(existing.duration(), duration)
                : duration;

        activeStatuses.put(canonical, new StatusRecord(newDuration, newIntensity));
    }

    @Override
    public int getStatusIntensity(AppliedStatusEnum status) {
        StatusRecord record = this.activeStatuses.get(status.getCanonicalStatus());
        return record != null ? record.intensity() : 0;
    }

    @Override
    public float getStatusModTotal(AppliedStatusEnum canonicalBase) {
        StatusRecord record = activeStatuses.get(canonicalBase);
        return record == null ? 0f : canonicalBase.modifier() * record.intensity();
    }

    @Override
    public boolean hasStatus(AppliedStatusEnum status) {
        AppliedStatusEnum canonical = status.getCanonicalStatus();
        StatusRecord record = this.activeStatuses.get(canonical);
        return record != null && record.intensity() >= status.weight();
    }

    // ==================
    // Stat modifications
    // ==================

    @Override
    public void applyStatMod(StatModEnum status, Integer duration) {
        StatModEnum canonical = status.getCanonicalStatus();
        StatModRecord existing = activeStatMods.get(canonical);

        int incomingIntensity = status.weight();
        int newIntensity = (existing != null)
                ? Math.min(existing.intensity() + incomingIntensity, canonical.maxIntensity())
                : Math.min(incomingIntensity, canonical.maxIntensity());

        int newDuration = (existing != null)
                ? Math.max(existing.duration(), duration)
                : duration;

        activeStatMods.put(canonical, new StatModRecord(newDuration, newIntensity));
    }

    @Override
    public int getStatModIntensity(StatModEnum status) {
        StatModRecord record = this.activeStatMods.get(status.getCanonicalStatus());
        return record != null ? record.intensity() : 0;
    }

    @Override
    public float getStatModTotal(StatModEnum canonicalBase) {
        StatModRecord record = activeStatMods.get(canonicalBase);
        return record == null ? 0f : canonicalBase.modifier() * record.intensity();
    }

    @Override
    public boolean hasStatModification(StatModEnum status) {
        return this.activeStatMods.containsKey(status);
    }

    @Override
    public void resetTurnStates() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetTurnStates'");
    }

}
