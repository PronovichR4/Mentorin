package by.epam.pronovich.homework05.task01.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    private static final long serialVersionUID = 1L;

    @Builder
    public Warrior(String name, Gender gender, T weapon) {
        super(name, 20, 100, gender, weapon);
    }

}
