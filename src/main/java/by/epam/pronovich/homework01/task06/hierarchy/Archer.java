package by.epam.pronovich.homework01.task06.hierarchy;

import by.epam.pronovich.homework01.task06.annotation.ProdCode;
import by.epam.pronovich.homework01.task06.annotation.ThisCodeSmells;

@ThisCodeSmells(reviewer = "Petya")
public class Archer<T extends RangeWeapon> extends Hero<T> {

    public Archer() {

    }

    private void testMet() {

    }

    @Deprecated
    @ProdCode
    @ThisCodeSmells(reviewer = "Vasia")
    @Override
    public String getName() {
        return super.getName();
    }

    public Archer(String name, Gender gender, T weapon) {
        super(name, 10, 90, gender, weapon);
    }
}
