package com.lugal.Enums;

public enum StatModEnum {
    
    // Buffs
    OOMPH,          // increases str by 100% for single target
    OOMPHLE,        // increases str by 50% for whole party
    BUFF,           // increases def by 50% for single target
    KABUFF,         // increases def by 25% for whole party
    ACCELERATE,     // increases agi by 50% for single target
    ACCELERATLE,    // increases agi by 25% for whole party
    PING,           // increases wis by 100% for single target
    KAPING,         // increases wis by 50% for whole party

    // Debuffs
    BLUNT,          // decrease atk 50% for one enemy
    KABLUNT,        // decrease atk 25% for one group
    SAP,            // decrease def 50% for one enemy
    KASAP,           // decrease def 25% for one group
    DECELERATE,     // decrease agi 50% for one enemy
    DECELERATLE,    // decrease agi 25% for one group
    DIM,            // decrease wis 50% for one enemy
    KADIM,          // decrease wis 25% for one group
}
