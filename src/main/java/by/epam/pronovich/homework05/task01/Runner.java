package by.epam.pronovich.homework05.task01;

import by.epam.pronovich.homework05.task01.entity.*;
import by.epam.pronovich.homework05.task01.util.SerializationUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static by.epam.pronovich.homework05.task01.entity.Gender.MALE;

public class Runner {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Archer<RangeWeapon> legalas = Archer.builder()
                .name("Legalas")
                .gender(MALE)
                .weapon(new Bow())
                .build();

        System.out.println(legalas);

        Path path = Paths.get("src", "main", "resources", "archer.txt");

        SerializationUtil.serializeObject(path, legalas);
        Archer archer = SerializationUtil.desirializeObjext(path);
        System.out.println(archer);

    }
}
