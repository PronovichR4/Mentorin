package by.epam.pronovich.homework01.task03;

import static by.epam.pronovich.homework01.task03.Gender.MALE;

public class Runner {

    public static void main(String[] args) {

        Warrior<MeleeWeapon> gorosh = new Warrior<MeleeWeapon>("Gorosh", MALE, new Axe());
        Archer<RangeWeapon> legolas = new Archer<>("Legolas", MALE, new Bow());
        gorosh.attack();
    }
}
