package by.epam.pronovich.homework05.task01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Hero<T extends Weapon> implements Mortal, Attack, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient int damage;
    private  transient int health;
    private Gender gender;
    private T weapon;



    public Hero(int damage, int health) {
        this.damage = damage;
        this.health = health;
    }

    public Hero(String name, Gender gender, T weapon) {
        this.name = name;
        this.gender = gender;
        this.weapon = weapon;
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
