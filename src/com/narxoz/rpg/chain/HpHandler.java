package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class HpHandler extends DefenseHandler {
    @Override
    public int handle(int damage, ArenaFighter target) {
        target.takeDamage(damage);
        return damage;
    }
}