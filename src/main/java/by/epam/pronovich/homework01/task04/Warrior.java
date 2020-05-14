package by.epam.pronovich.homework01.task04;

public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    public Warrior() {
        super(20, 100);
    }

    public Warrior(String name, Gender gender, T weapon) {
        super(name, 20, 100, gender, weapon);
    }

    private void privateMethod() {
        System.out.println("Call private metgod");
    }

}
