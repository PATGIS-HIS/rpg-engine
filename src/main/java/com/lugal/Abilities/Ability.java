package com.lugal.Abilities;

import java.util.List;

import com.lugal.BattleLogic.BattleActionProcessor;
import com.lugal.Entities.TargetableEntity;
import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatusEnum;
import com.lugal.Enums.TargetEnum;

public class Ability {
    private final String name;
    private final int mpCost;
    private final TargetEnum targetScope;
    private final ElementEnum element;
    private final StatusEnum status;
    private final AbilityEffect effect;

    private Ability(Builder builder) {
        this.name = builder.name;
        this.mpCost = builder.mpCost;
        this.targetScope = builder.targetScope;
        this.element = builder.element;
        this.status = builder.status;
        this.effect = builder.effect;
    }

    public void execute(TargetableEntity caster, List<TargetableEntity> targets, BattleActionProcessor processor) {
        targetScope.filterTargets(caster, targets).forEach(target -> {
            effect.apply(caster, target, processor);
        });
    }

    public String getName() { return name; }
    public int getMpCost() { return mpCost; }
    public TargetEnum getTargetScope() { return targetScope; }
    public ElementEnum getElement() { return element; }
    public StatusEnum getStatus() { return status; }

    public interface AbilityEffect {
        void apply(TargetableEntity caster, TargetableEntity target, BattleActionProcessor processor);
    }

    public static class Builder {
        private String name = "";
        private int mpCost = 0;
        private TargetEnum targetScope = TargetEnum.SINGLE_ENEMY;
        private ElementEnum element = ElementEnum.NONE;
        private StatusEnum status = null;
        private AbilityEffect effect = (caster, target, processor) -> {};

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder setMpCost(int mpCost) {
            this.mpCost = mpCost;
            return this;
        }

        public Builder setTargetScope(TargetEnum targetScope) {
            this.targetScope = targetScope;
            return this;
        }

        public Builder setElementType(ElementEnum element) {
            this.element = element;
            return this;
        }

        public Builder setStatusEffect(StatusEnum status) {
            this.status = status;
            return this;
        }

        public Builder setEffect(AbilityEffect effect) {
            this.effect = effect;
            return this;
        }

        public Ability build() {
            return new Ability(this);
        }
    }
}