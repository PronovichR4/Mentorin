package by.epam.pronovich.homework01.task06.hierarchy;

import by.epam.pronovich.homework01.task06.annotation.ThisCodeSmells;

public class Bow implements RangeWeapon {

    @ThisCodeSmells(reviewer = "Vasia")
    @Override
    public int getDamage() {
        return 5;
    }
}
