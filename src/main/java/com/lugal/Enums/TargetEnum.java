package com.lugal.Enums;

import java.util.List;

import com.lugal.Entities.TargetableEntity;

/**
 * Enum of target types
 */
public enum TargetEnum {
    SINGLE_ENEMY,   // target a single enemy
    SINGLE_ALLY,    // target a single ally
    ALL_ENEMIES,    // target all enemies
    ALL_ALLIES,     // target all allies
    GROUP;          // target single group of enemies

    public List<TargetableEntity> filterTargets(TargetableEntity caster, List<TargetableEntity> pool) {
        // TODO
        return pool;
    }
}
