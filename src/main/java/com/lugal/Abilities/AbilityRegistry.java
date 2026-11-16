package com.lugal.Abilities;

import java.lang.Thread.State;
import java.util.HashMap;
import java.util.Map;

import com.lugal.Enums.AppliedStatusEnum;
import com.lugal.Enums.ElementEnum;
import com.lugal.Enums.StatEnum;
import com.lugal.Enums.StatModEnum;
import com.lugal.Enums.TargetEnum;
import com.lugal.Utils.RNG;

public class AbilityRegistry {
    private static final Map<String, Ability> ABILITIES = new HashMap<>();

    private static void REGISTER(String key, Ability ability) {
        ABILITIES.put(key, ability);
    }

    static {
        REGISTER("attack", new Ability.Builder()
                .setName("Attack")
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target, ElementEnum.NONE,
                            1f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // ===============
        // Offensive Magic
        // ===============

        // Fire magic
        REGISTER("frizz", new Ability.Builder()
                .setName("Frizz")
                .setMpCost(2)
                .setElementType(ElementEnum.FIRE_MAG)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.FIRE_MAG, 150,
                            new int[] { 11, 15 },
                            new int[] { 34, 38 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("frizzle", new Ability.Builder()
                .setName("Frizzle")
                .setMpCost(4)
                .setElementType(ElementEnum.FIRE_MAG)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.FIRE_MAG, 287,
                            new int[] { 70, 80 },
                            new int[] { 106, 122 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kafrizz", new Ability.Builder()
                .setName("Kafrizz")
                .setMpCost(12)
                .setElementType(ElementEnum.FIRE_MAG)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.FIRE_MAG, 344,
                            new int[] { 178, 201 },
                            new int[] { 307, 331 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kafrizzle", new Ability.Builder()
                .setName("Kafrizzle")
                .setMpCost(45)
                .setElementType(ElementEnum.FIRE_MAG)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.FIRE_MAG, 999,
                            new int[] { 366, 398 },
                            new int[] { 748, 780 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        REGISTER("sizz", new Ability.Builder()
                .setName("Sizz")
                .setMpCost(3)
                .setElementType(ElementEnum.FIRE_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.FIRE_MAG, 135,
                            new int[] { 16, 14 },
                            new int[] { 36, 48 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("sizzle", new Ability.Builder()
                .setName("Sizzle")
                .setMpCost(7)
                .setElementType(ElementEnum.FIRE_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.FIRE_MAG, 222,
                            new int[] { 36, 44 },
                            new int[] { 82, 90 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kasizz", new Ability.Builder()
                .setName("Kasizz")
                .setMpCost(16)
                .setElementType(ElementEnum.FIRE_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.FIRE_MAG, 332,
                            new int[] { 100, 116 },
                            new int[] { 216, 232 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kasizzle", new Ability.Builder()
                .setName("Kasizzle")
                .setMpCost(48)
                .setElementType(ElementEnum.FIRE_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.FIRE_MAG, 999,
                            new int[] { 308, 340 },
                            new int[] { 632, 664 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // Ice magic
        REGISTER("crack", new Ability.Builder()
                .setName("Crack")
                .setMpCost(3)
                .setElementType(ElementEnum.ICE_MAG)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.ICE_MAG,
                            174,
                            new int[] { 25, 35 },
                            new int[] { 114, 123 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("crackle", new Ability.Builder()
                .setName("Crackle")
                .setMpCost(8)
                .setElementType(ElementEnum.ICE_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.ICE_MAG,
                            249,
                            new int[] { 42, 58 },
                            new int[] { 142, 157 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kacrack", new Ability.Builder()
                .setName("Kacrack")
                .setMpCost(20)
                .setElementType(ElementEnum.ICE_MAG)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.ICE_MAG,
                            323,
                            new int[] { 104, 136 },
                            new int[] { 224, 256 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kacrackle", new Ability.Builder()
                .setName("Kacrackle")
                .setMpCost(55)
                .setElementType(ElementEnum.ICE_MAG)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.ICE_MAG,
                            999,
                            new int[] { 328, 392 },
                            new int[] { 688, 752 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // Wind magic
        REGISTER("woosh", new Ability.Builder()
                .setName("Woosh")
                .setMpCost(3)
                .setElementType(ElementEnum.WIND_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.WIND_MAG, 160,
                            new int[] { 12, 36 },
                            new int[] { 61, 77 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("swoosh", new Ability.Builder()
                .setName("Swoosh")
                .setMpCost(8)
                .setElementType(ElementEnum.WIND_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.WIND_MAG, 244,
                            new int[] { 48, 112 },
                            new int[] { 123, 156 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kaswoosh", new Ability.Builder()
                .setName("Kaswoosh")
                .setMpCost(26)
                .setElementType(ElementEnum.WIND_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.WIND_MAG, 322,
                            new int[] { 80, 180 },
                            new int[] { 155, 255 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kaswooshle", new Ability.Builder()
                .setName("Kaswooshle")
                .setMpCost(50)
                .setElementType(ElementEnum.WIND_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.WIND_MAG, 999,
                            new int[] { 258, 514 },
                            new int[] { 496, 752 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // Explosion magic
        REGISTER("bang", new Ability.Builder()
                .setName("Bang")
                .setMpCost(5)
                .setElementType(ElementEnum.BANG_MAG)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.BANG_MAG, 195,
                            new int[] { 15, 30 },
                            new int[] { 70, 80 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("boom", new Ability.Builder()
                .setName("Boom")
                .setMpCost(10)
                .setElementType(ElementEnum.BANG_MAG)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.BANG_MAG, 273,
                            new int[] { 52, 68 },
                            new int[] { 152, 168 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kaboom", new Ability.Builder()
                .setName("Kaboom")
                .setMpCost(24)
                .setElementType(ElementEnum.BANG_MAG)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.BANG_MAG, 390,
                            new int[] { 156, 172 },
                            new int[] { 262, 278 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kaboomle", new Ability.Builder()
                .setName("Kaboomle")
                .setMpCost(60)
                .setElementType(ElementEnum.BANG_MAG)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.BANG_MAG, 999,
                            new int[] { 344, 376 },
                            new int[] { 704, 736 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // Lightning magic
        REGISTER("zap", new Ability.Builder()
                .setName("Zap")
                .setMpCost(5)
                .setElementType(ElementEnum.LIGHTNING_MAG)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.LIGHTNING_MAG, 141,
                            new int[] { 31, 41 },
                            new int[] { 131, 141 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("zapple", new Ability.Builder()
                .setName("Zapple")
                .setMpCost(22)
                .setElementType(ElementEnum.LIGHTNING_MAG)
                .setTargetScope(TargetEnum.GROUP)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.LIGHTNING_MAG, 315,
                            new int[] { 146, 166 },
                            new int[] { 314, 334 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kazap", new Ability.Builder()
                .setName("Kazap")
                .setMpCost(48)
                .setElementType(ElementEnum.LIGHTNING_MAG)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.LIGHTNING_MAG, 999,
                            new int[] { 335, 385 },
                            new int[] { 695, 745 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // Dark magic
        REGISTER("zam", new Ability.Builder()
                .setName("Zam")
                .setMpCost(4)
                .setElementType(ElementEnum.DARK_MAG)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.DARK_MAG, 145,
                            new int[] { 16, 32 },
                            new int[] { 131, 147 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("zammle", new Ability.Builder()
                .setName("Zammle")
                .setMpCost(7)
                .setElementType(ElementEnum.DARK_MAG)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.DARK_MAG, 238,
                            new int[] { 82, 94 },
                            new int[] { 213, 243 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kazam", new Ability.Builder()
                .setName("Kazam")
                .setMpCost(18)
                .setElementType(ElementEnum.DARK_MAG)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.DARK_MAG, 323,
                            new int[] { 120, 180 },
                            new int[] { 315, 375 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("kazammle", new Ability.Builder()
                .setName("Kazammle")
                .setMpCost(42)
                .setElementType(ElementEnum.DARK_MAG)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateMagicalDamage(caster, target,
                            ElementEnum.DARK_MAG, 999,
                            new int[] { 303, 316 },
                            new int[] { 585, 645 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // =============
        // Healing Magic
        // =============

        // Single target healing
        REGISTER("heal", new Ability.Builder()
                .setName("Heal")
                .setMpCost(2)
                .setTargetScope(TargetEnum.SINGLE_ALLY)
                .setEffect((caster, target, processor) -> {
                    int heal = processor.calculateMagicalDamage(caster, target, ElementEnum.NONE,
                            999,
                            new int[] { 30, 40 },
                            new int[] { 155, 165 });
                    target.modifyStat(StatEnum.HP, heal);
                })
                .build());
        REGISTER("midheal", new Ability.Builder()
                .setName("Midheal")
                .setMpCost(4)
                .setTargetScope(TargetEnum.SINGLE_ALLY)
                .setEffect((caster, target, processor) -> {
                    int heal = processor.calculateMagicalDamage(caster, target, ElementEnum.NONE,
                            999,
                            new int[] { 75, 95 },
                            new int[] { 290, 310 });
                    target.modifyStat(StatEnum.HP, heal);
                })
                .build());
        REGISTER("moreheal", new Ability.Builder()
                .setName("Moreheal")
                .setMpCost(8)
                .setTargetScope(TargetEnum.SINGLE_ALLY)
                .setEffect((caster, target, processor) -> {
                    int heal = processor.calculateMagicalDamage(caster, target, ElementEnum.NONE,
                            999,
                            new int[] { 165, 205 },
                            new int[] { 580, 620 });
                    target.modifyStat(StatEnum.HP, heal);
                })
                .build());
        REGISTER("fullheal", new Ability.Builder()
                .setName("Fullheal")
                .setMpCost(18)
                .setTargetScope(TargetEnum.SINGLE_ALLY)
                .setEffect((caster, target, processor) -> {
                    int heal = processor.calculateMagicalDamage(caster, target, ElementEnum.NONE,
                            999,
                            new int[] { 999, 999 },
                            new int[] { 999, 999 });
                    target.modifyStat(StatEnum.HP, heal);
                })
                .build());

        // Multitarget healing
        REGISTER("multiheal", new Ability.Builder()
                .setName("Multiheal")
                .setMpCost(16)
                .setTargetScope(TargetEnum.ALL_ALLIES)
                .setEffect((caster, target, processor) -> {
                    int heal = processor.calculateMagicalDamage(caster, target, ElementEnum.NONE,
                            999,
                            new int[] { 100, 120 },
                            new int[] { 330, 350 });
                    target.modifyStat(StatEnum.HP, heal);
                })
                .build());
        REGISTER("omniheal", new Ability.Builder()
                .setName("Omniheal")
                .setMpCost(54)
                .setTargetScope(TargetEnum.ALL_ALLIES)
                .setEffect((caster, target, processor) -> {
                    int heal = processor.calculateMagicalDamage(caster, target, ElementEnum.NONE,
                            999,
                            new int[] { 999, 999 },
                            new int[] { 999, 999 });
                    target.modifyStat(StatEnum.HP, heal);
                })
                .build());

        // =======
        // Slashes
        // =======

        // Elemental Slashes
        REGISTER("flame slash", new Ability.Builder()
                .setName("Flame Slash")
                .setElementType(ElementEnum.FIRE_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.FIRE_PHYS, 1.3f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("inferno slash", new Ability.Builder()
                .setName("Inferno Slash")
                .setMpCost(5)
                .setElementType(ElementEnum.FIRE_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.FIRE_PHYS, 1.6f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("frost slash", new Ability.Builder()
                .setName("Frost Slash")
                .setElementType(ElementEnum.ICE_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.ICE_PHYS, 1.3f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("blizzard slash", new Ability.Builder()
                .setName("Blizzard Slash")
                .setMpCost(5)
                .setElementType(ElementEnum.ICE_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.ICE_PHYS, 1.6f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("gust slash", new Ability.Builder()
                .setName("Gust Slash")
                .setElementType(ElementEnum.WIND_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.WIND_PHYS, 1.3f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("gale slash", new Ability.Builder()
                .setName("Gale Slash")
                .setMpCost(5)
                .setElementType(ElementEnum.WIND_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.WIND_PHYS, 1.6f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("lightning slash", new Ability.Builder()
                .setName("Lightning Slash")
                .setElementType(ElementEnum.LIGHTNING_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.LIGHTNING_PHYS, 1.3f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("thunderbolt slash", new Ability.Builder()
                .setName("Thunderbolt Slash")
                .setMpCost(5)
                .setElementType(ElementEnum.LIGHTNING_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.LIGHTNING_PHYS, 1.6f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("hallowed slash", new Ability.Builder()
                .setName("Hallowed Slash")
                .setElementType(ElementEnum.LIGHT_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.LIGHT_PHYS, 1.3f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("sacred slash", new Ability.Builder()
                .setName("Sacred Slash")
                .setMpCost(5)
                .setElementType(ElementEnum.LIGHT_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.LIGHT_PHYS, 1.6f);
                    target.modifyStat(StatEnum.HP, -damage);

                })
                .build());
        REGISTER("shade slash", new Ability.Builder()
                .setName("Shade Slash")
                .setElementType(ElementEnum.DARK_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.DARK_PHYS, 1.3f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("shadow slash", new Ability.Builder()
                .setName("Shadow Slash")
                .setMpCost(5)
                .setElementType(ElementEnum.DARK_PHYS)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target,
                            ElementEnum.DARK_PHYS, 1.6f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // Status Slashes
        REGISTER("sleep attack", new Ability.Builder()
                .setName("Sleep Attack")
                .setMpCost(4)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target, ElementEnum.NONE,
                            .8f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("poison attack", new Ability.Builder()
                .setName("Poison Attack")
                .setMpCost(4)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target, ElementEnum.NONE,
                            .8f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("venom attack", new Ability.Builder()
                .setName("Venom Attack")
                .setMpCost(4)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target, ElementEnum.NONE,
                            .8f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("paralysis attack", new Ability.Builder()
                .setName("Paralysis Attack")
                .setMpCost(4)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculatePhysicalDamage(caster, target, ElementEnum.NONE,
                            .8f);
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // ==============
        // Breath Attacks
        // ==============

        // Fire breath
        REGISTER("fire breath", new Ability.Builder()
                .setName("Fire Breath")
                .setElementType(ElementEnum.FIRE_PHYS)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateBreathDamage(caster, target,
                            ElementEnum.FIRE_PHYS, new int[] { 20, 30 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("flame breath", new Ability.Builder()
                .setName("Flame Breath")
                .setElementType(ElementEnum.FIRE_PHYS)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateBreathDamage(caster, target,
                            ElementEnum.FIRE_PHYS, new int[] { 40, 60 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("scorch", new Ability.Builder()
                .setName("Scorch")
                .setElementType(ElementEnum.FIRE_PHYS)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateBreathDamage(caster, target,
                            ElementEnum.FIRE_PHYS, new int[] { 150, 170 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("hellfire", new Ability.Builder()
                .setName("Hellfire")
                .setMpCost(15)
                .setElementType(ElementEnum.FIRE_PHYS)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateBreathDamage(caster, target,
                            ElementEnum.FIRE_PHYS, new int[] { 210, 250 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // Ice breath
        REGISTER("cool breath", new Ability.Builder()
                .setName("Cool Breath")
                .setElementType(ElementEnum.ICE_PHYS)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateBreathDamage(caster, target,
                            ElementEnum.ICE_MAG, new int[] { 30, 45 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("chilly breath", new Ability.Builder()
                .setName("Chilly Breath")
                .setElementType(ElementEnum.ICE_PHYS)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateBreathDamage(caster, target,
                            ElementEnum.ICE_MAG, new int[] { 50, 60 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("Freezing Blizzard", new Ability.Builder()
                .setName("Freezing Blizzard")
                .setElementType(ElementEnum.ICE_PHYS)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateBreathDamage(caster, target,
                            ElementEnum.ICE_MAG, new int[] { 120, 140 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());
        REGISTER("c-c-cold breath", new Ability.Builder()
                .setName("C-c-cold Breath")
                .setMpCost(12)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    int damage = processor.calculateBreathDamage(caster, target,
                            ElementEnum.ICE_PHYS, new int[] { 210, 230 });
                    target.modifyStat(StatEnum.HP, -damage);
                })
                .build());

        // Status breath
        REGISTER("poison breath", new Ability.Builder()
                .setName("Poison Breath")
                .setMpCost(3)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {

                    target.applyStatus(AppliedStatusEnum.POISON, 3);
                })
                .build());
        REGISTER("venom breath", new Ability.Builder()
                .setName("Venom Breath")
                .setMpCost(8)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatus(AppliedStatusEnum.VENOM, 3);
                })
                .build());
        REGISTER("paralysing gas", new Ability.Builder()
                .setName("Paralysing Gas")
                .setMpCost(5)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatus(AppliedStatusEnum.PARALYZE, 3);
                })
                .build());
        REGISTER("sweet breath", new Ability.Builder()
                .setName("Sweet Breath")
                .setMpCost(5)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatus(AppliedStatusEnum.SNOOZE, 3);
                })
                .build());
        REGISTER("sandstorm", new Ability.Builder()
                .setName("Sandstorm")
                .setMpCost(5)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatus(AppliedStatusEnum.DAZZLE, 3);
                })
                .build());

        // Buffs
        REGISTER("oomph", new Ability.Builder()
                .setName("Oomph")
                .setMpCost(6)
                .setTargetScope(TargetEnum.SINGLE_ALLY)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.OOMPH, RNG.rand(6, 9));
                })
                .build());
        REGISTER("gritty ditty", new Ability.Builder()
                .setName("Gritty Ditty")
                .setMpCost(8)
                .setTargetScope(TargetEnum.ALL_ALLIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.GRITTY_DITTY, RNG.rand(6, 9));
                })
                .build());
        REGISTER("ping", new Ability.Builder()
                .setName("Ping")
                .setMpCost(4)
                .setTargetScope(TargetEnum.SINGLE_ALLY)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.PING, RNG.rand(6, 9));
                })
                .build());
        REGISTER("kaping", new Ability.Builder()
                .setName("Kaping")
                .setMpCost(7)
                .setTargetScope(TargetEnum.ALL_ALLIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.KAPING, RNG.rand(6, 9));
                })
                .build());
        REGISTER("buff", new Ability.Builder()
                .setName("Buff")
                .setMpCost(3)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.BUFF, RNG.rand(6, 9));
                })
                .build());
        REGISTER("kabuff", new Ability.Builder()
                .setName("Kabuff")
                .setMpCost(4)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.KABUFF, RNG.rand(6, 9));
                })
                .build());
        REGISTER("accelerate", new Ability.Builder()
                .setName("Accelerate")
                .setMpCost(2)
                .setTargetScope(TargetEnum.SINGLE_ALLY)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.ACCELERATE, RNG.rand(6, 9));
                })
                .build());
        REGISTER("acceleratle", new Ability.Builder()
                .setName("Acceleratle")
                .setMpCost(4)
                .setTargetScope(TargetEnum.ALL_ALLIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.ACCELERATLE, RNG.rand(6, 9));
                })
                .build());
        REGISTER("blunt", new Ability.Builder()
                .setName("Blunt")
                .setMpCost(6)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.BLUNT, RNG.rand(6, 9));
                })
                .build());
        REGISTER("kablunt", new Ability.Builder()
                .setName("Kablunt")
                .setMpCost(8)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.KABLUNT, RNG.rand(6, 9));
                })
                .build());
        REGISTER("dim", new Ability.Builder()
                .setName("Dim")
                .setMpCost(3)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.DIM, RNG.rand(6, 9));
                })
                .build());
        REGISTER("kadim", new Ability.Builder()
                .setName("Kadim")
                .setMpCost(5)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.KADIM, RNG.rand(6, 9));
                })
                .build());
        REGISTER("sap", new Ability.Builder()
                .setName("Sap")
                .setMpCost(3)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.SAP, RNG.rand(6, 9));
                })
                .build());
        REGISTER("kasap", new Ability.Builder()
                .setName("Kasap")
                .setMpCost(5)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.KASAP, RNG.rand(6, 9));
                })
                .build());
        REGISTER("decelerate", new Ability.Builder()
                .setName("Decelerate")
                .setMpCost(3)
                .setTargetScope(TargetEnum.SINGLE_ENEMY)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.DECELERATE, RNG.rand(6, 9));
                })
                .build());
        REGISTER("deceleratle", new Ability.Builder()
                .setName("Deceleratle")
                .setMpCost(4)
                .setTargetScope(TargetEnum.ALL_ENEMIES)
                .setEffect((caster, target, processor) -> {
                    target.applyStatMod(StatModEnum.DECELERATLE, RNG.rand(6, 9));
                })
                .build());
        
    }
}
