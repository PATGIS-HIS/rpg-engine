package com.lugal.Enums;

/**
 * Enum of stat modifiers
 */
public enum StatModEnum {
    OOMPH(1.0f),
    OOMPHLE(0.5f),
    BUFF(0.5f),
    KABUFF(0.25f),
    ACCELERATE(0.5f),
    ACCELERATLE(0.25f),
    PING(1.0f),
    KAPING(0.5f),
    BLUNT(-0.5f),
    KABLUNT(-0.25f),
    SAP(-0.5f),
    KASAP(-0.25f),
    DECELERATE(-0.5f),
    DECELERATLE(-0.25f),
    DIM(-0.5f),
    KADIM(-0.25f);

    private final float modifier;

    StatModEnum(float modifier) {
        this.modifier = modifier;
    }

    public float modifier() {
        return modifier;
    }
}

