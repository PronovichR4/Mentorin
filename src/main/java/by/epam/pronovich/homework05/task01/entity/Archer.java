package by.epam.pronovich.homework05.task01.entity;


import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
public class Archer<T extends RangeWeapon> extends Hero<T> {

    private static final long serialVersionUID = 1L;

    @Builder
    public Archer(String name, Gender gender, T weapon) {
        super(name, 10, 90, gender, weapon);
    }
}
