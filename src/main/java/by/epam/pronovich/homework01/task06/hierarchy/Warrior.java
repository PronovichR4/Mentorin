package by.epam.pronovich.homework01.task06.hierarchy;


import by.epam.pronovich.homework01.task06.annotation.ProdCode;
import by.epam.pronovich.homework01.task06.annotation.ThisCodeSmells;


@ThisCodeSmells(reviewer = "Petya")
public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    public Warrior() {
        super(20, 100);
    }

    @ProdCode
    public void testMeth() {

    }

    public Warrior(String name, Gender gender, T weapon) {
        super(name, 20, 100, gender, weapon);
    }
}
