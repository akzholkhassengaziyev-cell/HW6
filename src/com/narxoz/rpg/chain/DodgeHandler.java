package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class DodgeHandler extends DefenseHandler {
    @Override
    public int handle(int damage, ArenaFighter target) {
        if (Math.random() < target.getDodgeChance()) {
            return 0;
        }
        return passToNext(damage, target);
    }
}