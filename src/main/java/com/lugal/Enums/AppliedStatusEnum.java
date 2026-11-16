package com.lugal.Enums;

/**
 * Statuses/abilities on a set timer
 */
public enum AppliedStatusEnum {
    PARALYZE(1, 1),                             // character is paralyzed
    POISON(1, 1),                               // character is poisoned
    VENOM(2, 2, POISON),                        // character is envenomated
    STUN(1, 1),                                 // character is stunned
    DAZZLE(2, 1),                               // character is dazzled
    SNOOZE(2, 1),                               // character is asleep
    KASNOOZE(2, 2, SNOOZE),                     // character is deeply asleep
    FIZZLE(1, 1),                               // prevents use of spells
    FUDDLE(1, 1),                               // charcter is confused
    CURSE(1, 1),                                // causes character to randomly freeze
    BAN_DANCE(1, 1),                            // prevents use of dances
    MOUTH_SHUT(1, 1),                           // prevents use of breath skills
    BOUND(1, 1),                                // bounces 1 spell
    BOUNCE(1, 1),                               // bounces all spells
    COUNTER(1, 1),                              // blocks and redirects attack to random enemy
    MAGIC_BARRIER(2, 1),                        // increases magic resist by 25% for whole party
    SPELL_CHECKER(2, 2, MAGIC_BARRIER),         // increases magic resist by 50% for single target
    SNUB(1, 1),                                 // blocks all incoming spells
    KACLANG(1, 1),                              // turns party to impregnable steel
    INSULATLE(2, 1),                            // increases breath resistance by 25% for whole party
    INSULATE(2, 2, INSULATLE),                  // increases breath resistance by 50% for single target
    ABSORB_MAGIC(1, 1),                         // absorbs mp from oncoming spells
    ANATHEMATISE(2, 1),                         // decrease magical resist 25% for one group
    DIVINE_INTERVENTION(2, 2, ANATHEMATISE),    // decrease magical resist 50% for one enemy
    DODGY_DANCE(1, 1),                          // increase base dodge chance to 50%
    FOCUS(1, 1),                                // increase next turn physical attack by 100%, always connect
    MUSTER_STRENGTH(1, 1),                      // increase next turn physical attack by 150%
    EGG_ON(1, 1),                               // increase next turn physical attack by 100%
    DEFENDING_CHAMPION(1, 1),                   // reduces all damage by 90%
    DEFEND(1, 1),                               // halves all damage
    CASTER_SUGAR(1, 1),                         // increase magical output by 50%
    DEEP_BREATH(1, 1);                          // increase next breath attack by 100%

    private final int maxIntensity;
    private final int weight;
    private final AppliedStatusEnum baseStatus;

    AppliedStatusEnum(int maxIntensity, int weight) {
        this.maxIntensity = maxIntensity;
        this.weight = weight;
        this.baseStatus = null;
    }

    AppliedStatusEnum(int maxIntensity, int weight, AppliedStatusEnum baseStatus) {
        this.maxIntensity = maxIntensity;
        this.weight = weight;
        this.baseStatus = baseStatus;
    }

    public int maxIntensity() {
        return maxIntensity;
    }

    public int weight() {
        return weight;
    }

    public AppliedStatusEnum getCanonicalStatus() {
        return baseStatus != null ? baseStatus : this;
    }
}
