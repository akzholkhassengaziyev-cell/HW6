package com.narxoz.rpg.arena;

public class ArenaOpponent {
    private final String name;
    private int health;
    private final int attackPower;

    public ArenaOpponent(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackPower() { return attackPower; }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public void heal(int amount) {
        health += amount;
    }

    public boolean isAlive() {
        return health > 0;
    }
}