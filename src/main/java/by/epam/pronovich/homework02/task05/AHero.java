package by.epam.pronovich.homework02.task05;

import java.util.List;
import java.util.Objects;

public class AHero {

    private String name;
    private int health;
    private List<String> weapons;

    public AHero() {
    }

    public AHero(String name, int health, List<String> weapons) {
        this.name = name;
        this.health = health;
        this.weapons = weapons;
    }

    public int getWeaponsQuantity() {
        return weapons.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<String> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<String> weapons) {
        this.weapons = weapons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AHero AHero = (AHero) o;
        return health == AHero.health &&
                Objects.equals(name, AHero.name) &&
                Objects.equals(weapons, AHero.weapons);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, health, weapons);
    }

    @Override
    public String toString() {
        return "AHero{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", weapons=" + weapons +
                '}';
    }
}
