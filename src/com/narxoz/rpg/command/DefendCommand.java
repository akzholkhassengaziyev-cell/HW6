package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.*;

public class DefendCommand implements ActionCommand {
    private final ArenaFighter fighter;
    private final double boost;

    public DefendCommand(ArenaFighter fighter, double boost) {
        this.fighter = fighter;
        this.boost = boost;
    }

    public void execute() {
        fighter.modifyDodgeChance(boost);
    }

    public void undo() {
        fighter.modifyDodgeChance(-boost);
    }

    public String getDescription() {
        return "Defend";
    }
}