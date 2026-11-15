package com.lugal.Entities;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Enums.StatusResistanceEnum;

public class Entity {
    
    private final String name;
    private final Map<StatEnum, Integer> stats;
    private final Map<ElementEnum, Float> elementResistances;
    private final Map<StatusResistanceEnum, Float> statusResistances;

    private Entity(Builder builder) {
        this.name = builder.name;
        this.stats = new EnumMap<>(builder.stats);
        this.elementResistances = new HashMap<>(builder.elementResistances);
        this.statusResistances = new HashMap<>(builder.statusResistances);
    }
    
    public String getName() { return name; }

    public int getStat(StatEnum stat) {
        return stats.getOrDefault(stat, 0);
    }

    public float getElementalResistances(ElementEnum type) {
        return elementResistances.getOrDefault(type, 0.0f);
    }

    public float getStatusResistances(StatusResistanceEnum type) {
        return statusResistances.getOrDefault(type, 0.0f);
    }

    static class Builder {
        private String name = "";
        
        private final Map<StatEnum, Integer> stats = new EnumMap<>(StatEnum.class);
        private final Map<ElementEnum, Float> elementResistances = new HashMap<>();
        private final Map<StatusResistanceEnum, Float> statusResistances = new HashMap<>();

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStat(StatEnum stat, int value) {
            stats.put(stat, value);
            return this;
        }

        public Builder setElementalResistance(ElementEnum type, float value) {
            elementResistances.put(type, value);
            return this;
        }

        public Builder setStatusResistance(StatusResistanceEnum effect, float value) {
            statusResistances.put(effect, value);
            return this;
        }

        public Entity build() {
            return new Entity(this);
        }
    }
}