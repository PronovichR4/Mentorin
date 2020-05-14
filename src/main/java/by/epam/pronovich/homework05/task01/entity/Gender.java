package by.epam.pronovich.homework05.task01.entity;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("Мужчина"),
    FEMALE("Женщина");

    private String description;

    Gender(String description) {
        this.description = description;
    }
}
