package com.narxoz.rpg;

import com.narxoz.rpg.arena.*;
import com.narxoz.rpg.command.*;
import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.tournament.*;

public class Main {
    public static void main(String[] args) {

        // COMMAND DEMO
        ArenaFighter hero = new ArenaFighter("Hero",100,20,5,20,0.2,2);
        ArenaOpponent enemy = new ArenaOpponent("Enemy",100,15);

        ActionQueue queue = new ActionQueue();
        queue.enqueue(new AttackCommand(hero, enemy));
        queue.enqueue(new HealCommand(hero, 20));
        queue.enqueue(new DefendCommand(hero, 0.1));

        System.out.println(queue.getCommandDescriptions());
        queue.undoLast();
        System.out.println(queue.getCommandDescriptions());

        queue.executeAll();

        // CHAIN DEMO
        DefenseHandler chain = new DodgeHandler();
        chain.setNext(new BlockHandler(0.2))
                .setNext(new ArmorHandler(5))
                .setNext(new HpHandler());

        chain.handle(20, hero);

        // TOURNAMENT
        TournamentEngine engine = new TournamentEngine();
        TournamentResult result = engine.runTournament(hero, enemy);

        System.out.println(result.getWinner());
        System.out.println(result.getRounds());
    }
}