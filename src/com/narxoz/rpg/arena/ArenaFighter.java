package com.narxoz.rpg.arena;

public class ArenaFighter {
    private final String name;
    private final int maxHealth;
    private int health;
    private final int attackPower;
    private final int armorValue;
    private final int blockRating;
    private double dodgeChance;
    private int potions;

    public ArenaFighter(String name, int maxHealth, int attackPower,
                        int armorValue, int blockRating, double dodgeChance, int potions) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.armorValue = armorValue;
        this.blockRating = blockRating;
        this.dodgeChance = dodgeChance;
        this.potions = potions;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getAttackPower() { return attackPower; }
    public int getArmorValue() { return armorValue; }
    public int getBlockRating() { return blockRating; }
    public double getDodgeChance() { return dodgeChance; }
    public int getPotions() { return potions; }

    public void takeDamage(int amount) {
        health -= Math.max(0, amount);
        if (health < 0) health = 0;
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
    }

    public void modifyDodgeChance(double delta) {
        dodgeChance += delta;
        if (dodgeChance < 0) dodgeChance = 0;
        if (dodgeChance > 1) dodgeChance = 1;
    }

    public void consumePotion() {
        if (potions > 0) potions--;
    }

    public void restorePotion() {
        potions++;
    }

    public boolean isAlive() {
        return health > 0;
    }
}