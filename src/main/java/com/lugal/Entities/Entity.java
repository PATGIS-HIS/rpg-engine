package com.lugal.Entities;

import java.util.HashMap;
import java.util.Map;

import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatusResistanceEnum;

public class Entity {
    
    private final String name;
    private final int hp, mp, atk, str, def, res, agi, wis, luck;
    private final Map<ElementEnum, Float> elementResistances;
    private final Map<StatusResistanceEnum, Float> statusResistances;

    private Entity(Builder builder) {
        this.name = builder.name;
        this.hp = builder.hp;
        this.mp = builder.mp;
        this.atk = builder.atk;
        this.agi = builder.agi;
        this.str = builder.str;
        this.def = builder.def;
        this.res = builder.res;
        this.luck = builder.luck;
        this.wis = builder.wis;
        
        this.elementResistances = new HashMap<>(builder.elementResistances);
        this.statusResistances = new HashMap<>(builder.statusResistances);
    }
    
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMp() { return mp; }
    public int getAtk() { return atk; }
    public int getStr() { return str; }
    public int getDef() { return def; }
    public int getRes() { return res; }
    public int getAgi() { return agi; }
    public int getWis() { return wis; }
    public int getLuck() { return luck; }

    public float getElementalResistances(ElementEnum type) {
        return elementResistances.getOrDefault(type, 0.0f);
    }

    public float getStatusResistances(StatusResistanceEnum type) {
        return statusResistances.getOrDefault(type, 0.0f);
    }

    static class Builder {

        private String name = "";
        private int hp, mp, atk, str, def, res, agi, wis, luck;

        private final Map<ElementEnum, Float> elementResistances = new HashMap<>();
        private final Map<StatusResistanceEnum, Float> statusResistances = new HashMap<>();

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
