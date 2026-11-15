package com.lugal.Enums;

/**
 * Statuses/abilities on a set timer
*/
public enum AppliedStatusEnum {
    PARALYZE,           // character is paralyzed
    POISON,             // character is poisoned
    VENOM,              // character is envenomated
    STUN,               // character is stunned
    DAZZLE,             // character is dazzled
    SLEEP,              // character is asleep
    FIZZLE,             // prevents use of spells
    FUDDLE,             // charcter is confused
    CURSE,              // causes character to randomly freeze
    BAN_DANCE,          // prevents use of dances
    MOUTH_SHUT,         // prevents use of breath skills
    BOUND,              // bounces 1 spell
    BOUNCE,             // bounces all spells
    COUNTER,            // blocks and redirects attack to random enemy
    SPELL_CHECKER,      // increases magic resist by 50% for single target
    MAGIC_BARRIER,      // increases magic resist by 25% for whole party
    SNUB,               // blocks all incoming spells
    KACLANG,            // turns party to impregnable steel
    INSULATE,           // increases breath resistance by 50% for single target
    INSULATLE,          // increases breath resistance by 25% for whole party
    ABSORB_MAGIC,       // absorbs mp from oncoming spells
    ANATHEMATISE,       // decrease magical resist 50% for one enemy
    DIVINE_INTERVENTION,// decrease magical resist 25% for one group
    DODGEY_DANCE,       // increase base dodge chance to 50%
    FOCUS,              // increase next turn physical attack by 100%, always connect
    MUSTER_STRENGTH,    // increase next turn physical attack by 150%
    EGG_ON,             // increase next turn physical attack by 100%
    DEFENDING_CHAMPION, // reduces all damage by 90%
    DEFEND,             // halves all damage
}
