package by.epam.pronovich.homework02.task02;

import by.epam.pronovich.homework02.task01.Person;

import java.util.Scanner;
import java.util.function.*;

public class Runner {

    public static void main(String[] args) {

        /**
         * Predicate
         */
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(5));
        System.out.println(isPositive.test(-5));

        Predicate<Person> predicate = it -> it.getName().length() > 5;
        System.out.println(predicate.test(new Person("Vasiliy")));

        /**
         * Runnable
         */
        Runnable runnable = () -> System.out.println("Do something");
        Thread thread = new Thread(runnable);
        thread.start();

        /**
         * Function
         */
        Function<Person, Integer> fromStringToInt = it -> it.getName().length();
        System.out.println(fromStringToInt.apply(new Person("Dasha")));

        /**
         * Supplier
         */
        Supplier<Person> supplier = () -> {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            return new Person(name);
        };

        Person person = supplier.get();
        System.out.println("Person name: " + person.getName());

        /**
         * Consumer
         */
        Consumer<Person> consumer = it -> System.out.println(it.toString());
        consumer.accept(new Person("Vovan", 26));

        /**
         * Create my own functional interface
         */
        SettableFuncInterface<Person> customFuncInterface = ((obj, name, age) -> {
            obj.setName(name);
            obj.setAge(age);
        });

        SettableFuncInterface<Person> settableFuncInterface = (obj, name, age) -> {
            obj.setName(name);
            obj.setAge(age);
        };

        Person secondPerson = new Person();
        settableFuncInterface.set(secondPerson,"TestCustomInterface",50);
        System.out.println(secondPerson);

        System.out.println(settableFuncInterface.defaultMethod());
        System.out.println(SettableFuncInterface.staticMethod());
    }
}
