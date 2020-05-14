package by.epam.pronovich.homework02.task05;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) {
        AHero archer = new AHero("Archer", 100, Arrays.asList("Лук", "Стрелы", "Нож"));
        AHero warrior = new AHero("Warrior", 120, Arrays.asList("Топор", "Меч", "Нож"));
        AHero mage = new AHero("Mage", 90, Arrays.asList("Посох", "Нож"));
        AHero warlock = new AHero("Warlock", 101, Arrays.asList("Посох", "Wand"));

        List<AHero> heroes = Arrays.asList(archer, warrior, mage, warlock);

        Stream<AHero> stream = heroes.stream();

        Integer collect1 = heroes.stream().parallel().collect(new AHeroColletor());
        System.out.println("Heroes with health more than 100: " + collect1);

    }
}
