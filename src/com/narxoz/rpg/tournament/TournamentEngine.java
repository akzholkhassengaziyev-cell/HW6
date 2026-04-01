package com.narxoz.rpg.tournament;

import com.narxoz.rpg.arena.*;
import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.command.*;

public class TournamentEngine {

    public TournamentResult runTournament(ArenaFighter hero, ArenaOpponent opponent) {
        TournamentResult result = new TournamentResult();

        DefenseHandler chain = new DodgeHandler();
        chain.setNext(new BlockHandler(hero.getBlockRating() / 100.0))
                .setNext(new ArmorHandler(hero.getArmorValue()))
                .setNext(new HpHandler());

        int round = 0;

        while (hero.isAlive() && opponent.isAlive() && round < 20) {
            round++;

            ActionQueue queue = new ActionQueue();
            queue.enqueue(new AttackCommand(hero, opponent));

            queue.executeAll();

            chain.handle(opponent.getAttackPower(), hero);
        }

        result.setRounds(round);
        result.setWinner(hero.isAlive() ? hero.getName() : opponent.getName());

        return result;
    }
}