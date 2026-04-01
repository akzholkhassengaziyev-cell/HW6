package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.*;

public class AttackCommand implements ActionCommand {
    private final ArenaFighter fighter;
    private final ArenaOpponent opponent;
    private int damage;

    public AttackCommand(ArenaFighter fighter, ArenaOpponent opponent) {
        this.fighter = fighter;
        this.opponent = opponent;
    }

    public void execute() {
        int before = opponent.getHealth();
        opponent.takeDamage(fighter.getAttackPower());
        damage = before - opponent.getHealth();
    }

    public void undo() {
        opponent.heal(damage);
    }

    public String getDescription() {
        return "Attack";
    }
}