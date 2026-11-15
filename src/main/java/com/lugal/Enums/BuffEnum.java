package com.lugal.Enums;

/**
 * Enum of support spells
 */
public enum BuffEnum {
    ABSORB_MAGIC,   // absorbs mp from oncoming spells
    ACCELERATE,     // increases agi by 50% for single target
    ACCELERATLE,    // increases agi by 25% for whole party
    BOUND,          // bounces 1 spell
    BOUNCE,         // bounces all spells
    BUFF,           // increases def by 50% for single target
    KABUFF,         // increases def by 25% for whole party
    COUNTER,        // blocks and redirects attack to random enemy
    INSULATE,       // increases breath resistance by 50% for single target
    INSULATLE,      // increases breath resistance by 25% for whole party
    KACLANG,        // turns party to impregnable steel
    SPELL_CHECKER,  // increases magic resist by 50% for single target
    MAGIC_BARRIER,  // increases magic resist by 25% for whole party
    OOMPH,          // increases str by 100% for single target
    OOMPHLE,        // increases str by 50% for whole party
    PING,           // increases wis by 100% for single target
    KAPING,         // increases wis by 50% for whole party
    SNUB            // blocks all incoming spells
}
