package com.lugal.Enums;

import java.util.List;

import com.lugal.Entities.TargetableEntity;

public enum TargetEnum {
    SINGLE_ENEMY,
    SINGLE_ALLY,
    ALL_ENEMIES,
    ALL_ALLIES,
    GROUP;

    public List<TargetableEntity> filterTargets(TargetableEntity caster, List<TargetableEntity> pool) {
        // TODO
        return pool;
    }
}
