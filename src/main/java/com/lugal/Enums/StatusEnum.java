package com.lugal.Enums;

/**
 * Enum of statuses/status resistances
 */
public enum StatusEnum {
    PARALYZE,
    POISON,
    VENOM,
    STUN,
    DAZZLE,
    SLEEP,
    FIZZLE,
    FUDDLE,
    BLUNT,
    SAP,
    SLOW,
    DIM,
    CURSE,
    BAN_DANCE,
    MOUTH_SHUT,
    BOUND,          // bounces 1 spell
    BOUNCE,         // bounces all spells
    COUNTER,        // blocks and redirects attack to random enemy
    SPELL_CHECKER,  // increases magic resist by 50% for single target
    MAGIC_BARRIER,  // increases magic resist by 25% for whole party
    SNUB,           // blocks all incoming spells
    KACLANG,        // turns party to impregnable steel
    INSULATE,       // increases breath resistance by 50% for single target
    INSULATLE,      // increases breath resistance by 25% for whole party
    ABSORB_MAGIC,   // absorbs mp from oncoming spells
    ANATHEMATISE,       // decrease magical resist 50% for one enemy
    DIVINE_INTERVENTION,// decrease magical resist 25% for one group
}