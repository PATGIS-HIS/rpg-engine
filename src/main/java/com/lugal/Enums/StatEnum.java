package com.lugal.Enums;

/**
 * core stats
 */
public enum StatEnum {
    HP,     // health points
    MP,     // magic points
    ATK,    // attack = str + weapon (unimplemented as of yet)
    STR,    // strength determines atk
    DEF,    // defence = res + armour (unimplemented as of yet)
    RES,    // resilience determines def
    AGI,    // agility determines turn order, evasion
    WIS,    // wisom determines spell damage
    LUCK    // determines avoidance of status effects, crit chance, spell crit chance
}
