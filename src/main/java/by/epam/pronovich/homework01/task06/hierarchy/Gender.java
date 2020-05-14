package by.epam.pronovich.homework01.task06.hierarchy;

public enum Gender {

    MALE("Мужчина"),
    FEMALE("Женщина");

    private String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
