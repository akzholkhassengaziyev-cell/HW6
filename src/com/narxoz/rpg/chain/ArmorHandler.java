package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class ArmorHandler extends DefenseHandler {
    private final int armor;

    public ArmorHandler(int armor) {
        this.armor = armor;
    }

    @Override
    public int handle(int damage, ArenaFighter target) {
        int reduced = Math.max(0, damage - armor);
        return passToNext(reduced, target);
    }
}