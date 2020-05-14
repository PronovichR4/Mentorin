package by.epam.pronovich.homework02.task03;

import by.epam.pronovich.homework02.task01.Person;

public class Runner {

    public static void main(String[] args) {

        ThreeFunction<Person, Person, Person, Double> threeFunc =
                (a, b, c) -> (a.getAge() + b.getAge() + c.getAge()) / 3.0;

        Double averageAge = threeFunc.apply(new Person("Vanya", 12), new Person("Vova", 20),
                new Person("Dasha", 15));

        System.out.println("Средний возраст: "+averageAge);

        ThreeFunction<Integer, String, Integer, String> tripleFunc = (a, b, c) -> a + b + c + "=" + (a + c);
        String apply = tripleFunc.apply(1, "+", 4);
        System.out.println(apply);
    }
}
