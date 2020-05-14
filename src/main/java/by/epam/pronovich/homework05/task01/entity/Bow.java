package by.epam.pronovich.homework05.task01.entity;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Bow implements RangeWeapon, Serializable {

    private static final long serialVersionUID = 1L;
    private String description="Bow";

    @Override
    public int getDamage() {
        return 5;
    }
}
