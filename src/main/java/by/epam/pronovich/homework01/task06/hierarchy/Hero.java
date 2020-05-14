package by.epam.pronovich.homework01.task06.hierarchy;

import by.epam.pronovich.homework01.task06.annotation.ThisCodeSmells;

public abstract class Hero<T extends Weapon> implements Mortal, Attack {

    private String name;
    @ThisCodeSmells(reviewer = "IVAN")
    private int damage;
    private int health;
    @ThisCodeSmells(reviewer = "IVAN")
    private Gender gender;
    private T weapon;

    public Hero() {

    }

    public Hero(int damage, int health) {
        this.damage = damage;
        this.health = health;
    }

    public Hero(String name, Gender gender, T weapon) {
        this.name = name;
        this.gender = gender;
        this.weapon = weapon;
    }

    public Hero(String name, int damage, int health, Gender gender, T weapon) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.gender = gender;
        this.weapon = weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    @ThisCodeSmells(reviewer = "Vasia")
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public T getWeapon() {
        return weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @deprecated outdated calculation algorithm of damage
     */
    @Deprecated
    public int attack() {
        return damage;
    }

    @Override
    public void strike(Hero hero) {
        int allDamege = damage = weapon.getDamage();
        hero.setHealth(hero.getHealth() - allDamege);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
