package by.epam.pronovich.homework02.task01;

import java.util.*;

public class Runner {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Vasya", 25));
        people.add(new Person("Grisha", 19));
        people.add(new Person("Volodya", 22));
        people.add(new Person("Petya", 16));

        Comparator<Person> byAge = Comparator.comparing(it -> it.getAge());
        Comparator<Person> byName = Comparator.comparing(it -> it.getName());

        System.out.println("Sort main.java.by name:");
        Collections.sort(people, byName);
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("Sort main.java.by age:");
        Collections.sort(people, byAge);
        people.forEach(System.out::println);
    }
}
