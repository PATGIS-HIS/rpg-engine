package com.lugal.Enums;

/**
 * Turn persistant modifiers to core stats
 */
public enum StatModEnum {
    GRITTY_DITTY(0.5f, 2, 1),
    OOMPH(1.0f, 2, 2, GRITTY_DITTY),
    KAPING(0.5f, 2, 1),
    PING(1.0f, 2, 2, KAPING),
    KABUFF(0.25f, 2, 1),
    BUFF(0.5f, 2, 2, KABUFF),
    ACCELERATLE(0.25f, 2, 1),
    ACCELERATE(0.5f, 2, 2, ACCELERATLE),
    KABLUNT(-0.25f, 2, 1),
    BLUNT(-0.5f, 2, 2, KABLUNT),
    KADIM(-0.25f, 2, 1),
    DIM(-0.5f, 2, 2, KADIM),
    KASAP(-0.25f, 2, 1),
    SAP(-0.5f, 2, 2, KASAP),
    DECELERATLE(-0.25f, 2, 1),
    DECELERATE(-0.5f, 2, 2, DECELERATLE);

    private final float modifier;
    private final int maxIntensity;
    private final int weight;
    private final StatModEnum baseMod;

    StatModEnum(float modifier, int maxIntensity, int weight) {
        this.modifier = modifier;
        this.maxIntensity = maxIntensity;
        this.weight = weight;
        this.baseMod = null;
    }

    StatModEnum(float modifier, int maxIntensity, int weight, StatModEnum baseMod) {
        this.modifier = modifier;
        this.maxIntensity = maxIntensity;
        this.weight = weight;
        this.baseMod = baseMod;
    }

    public float modifier() {
        return modifier;
    }

    public int maxIntensity() {
        return maxIntensity;
    }

    public int weight() {
        return weight;
    }

    public StatModEnum getCanonicalStatus() {
        return baseMod != null ? baseMod : this;
    }
}