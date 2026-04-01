package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.*;

public class HealCommand implements ActionCommand {
    private final ArenaFighter fighter;
    private final int amount;
    private int healed;

    public HealCommand(ArenaFighter fighter, int amount) {
        this.fighter = fighter;
        this.amount = amount;
    }

    public void execute() {
        int before = fighter.getHealth();
        fighter.heal(amount);
        healed = fighter.getHealth() - before;
        fighter.consumePotion();
    }

    public void undo() {
        fighter.takeDamage(healed);
        fighter.restorePotion();
    }

    public String getDescription() {
        return "Heal";
    }
}