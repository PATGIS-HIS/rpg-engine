package com.lugal.Enums;

/**
 * Statuses/abilities on a set timer
 */
public enum AppliedStatusEnum {
    // Non-modifier statuses (default modifier = 0f)
    PARALYZE(1, 1),
    POISON(1, 1),
    VENOM(2, 2, POISON),
    STUN(1, 1),
    DAZZLE(2, 1),
    SNOOZE(2, 1),
    KASNOOZE(2, 2, SNOOZE),
    FIZZLE(1, 1),
    FUDDLE(1, 1),
    CURSE(1, 1),
    BAN_DANCE(1, 1),
    MOUTH_SHUT(1, 1),
    BOUND(1, 1),
    BOUNCE(1, 1),
    COUNTER(1, 1),
    SNUB(1, 1),
    KACLANG(1, 1),
    ABSORB_MAGIC(1, 1),

    // Parameterized modifier statuses (base holds the per-intensity value)
    MAGIC_BARRIER(0.25f, 2, 1),                      // +25% magic resist per stack
    SPELL_CHECKER(0.50f, 2, 2, MAGIC_BARRIER),       // applies 2 stacks of MAGIC_BARRIER (50%)
    INSULATLE(0.25f, 2, 1),                          // +25% breath resist per stack
    INSULATE(0.50f, 2, 2, INSULATLE),                // applies 2 stacks of INSULATLE (50%)
    ANATHEMATISE(0.25f, 2, 1),                       // -25% magic resist per stack
    DIVINE_INTERVENTION(0.50f, 2, 2, ANATHEMATISE),  // applies 2 stacks of ANATHEMATISE (50%)
    DODGY_DANCE(0.50f, 1, 1),                        // sets dodge chance to 50%
    FOCUS(1.0f, 1, 1),                               // +100% physical dmg
    MUSTER_STRENGTH(1.5f, 1, 1),                     // +150% physical dmg
    EGG_ON(1.0f, 1, 1),                              // +100% physical dmg
    DEFENDING_CHAMPION(0.1f, 1, 1),                  // 0.1x incoming damage multiplier
    DEFEND(0.5f, 1, 1),                              // 0.5x incoming damage multiplier
    CASTER_SUGAR(0.5f, 1, 1),                        // +50% magical output
    DEEP_BREATH(1.0f, 1, 1);                         // +100% breath output

    private final float modifier;
    private final int maxIntensity;
    private final int weight;
    private final AppliedStatusEnum baseStatus;

    AppliedStatusEnum(int maxIntensity, int weight) {
        this(0f, maxIntensity, weight, null);
    }

    AppliedStatusEnum(int maxIntensity, int weight, AppliedStatusEnum baseStatus) {
        this(0f, maxIntensity, weight, baseStatus);
    }

    AppliedStatusEnum(float modifier, int maxIntensity, int weight) {
        this(modifier, maxIntensity, weight, null);
    }

    AppliedStatusEnum(float modifier, int maxIntensity, int weight, AppliedStatusEnum baseStatus) {
        this.modifier = modifier;
        this.maxIntensity = maxIntensity;
        this.weight = weight;
        this.baseStatus = baseStatus;
    }

    public float modifier() { return modifier; }
    public int maxIntensity() { return maxIntensity; }
    public int weight() { return weight; }
    public AppliedStatusEnum getCanonicalStatus() {
        return baseStatus != null ? baseStatus : this;
    }
}