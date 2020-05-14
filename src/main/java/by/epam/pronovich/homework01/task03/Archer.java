package by.epam.pronovich.homework01.task03;

public class Archer<T extends RangeWeapon> extends Hero<T> {

    public Archer() {

    }

    public Archer(String name, Gender gender, T weapon) {
        super(name, 10, 90, gender, weapon);
    }
}
