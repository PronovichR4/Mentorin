package by.epam.pronovich.homework01.task06.hierarchy;

import by.epam.pronovich.homework01.task06.annotation.ThisCodeSmells;

public interface Weapon {

    @ThisCodeSmells(reviewer = "IVAN")
    String testField = "testValue";

    int getDamage();
}
