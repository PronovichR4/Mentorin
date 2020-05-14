package by.epam.pronovich.homework01.task05;

public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    public Warrior(){
        super( 20, 100);
    }

    static class B{

    }


    public Warrior(String name, Gender gender, T weapon) {
        super(name, 20, 100, gender, weapon);
    }

}
