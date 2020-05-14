package by.epam.pronovich.homework01.task04;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static by.epam.pronovich.homework01.task04.Gender.MALE;

public class Runner {

    public static void main(String[] args) {

        Reflection reflection = new Reflection();

        Warrior warrior = null;
        Class<Warrior> warriorClass = Warrior.class;

        warrior=(Warrior)reflection.createObject(warriorClass);

        // Use reflection to instantiate object in client code via constructors with arguments
        Warrior warWithParams = null;
        Class[] params = {String.class, Gender.class, MeleeWeapon.class};
        try {
            warWithParams = warriorClass.getConstructor(params).newInstance("Gorosh", MALE, new Axe());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Use reflection API to fill private fields without setters
        try {
            Class aClass = warWithParams.getClass();
            Class superclass = aClass.getSuperclass();
            Field name = superclass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(warWithParams, "Test");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Use reflection API to change method calls from direct call on reflection call in client code

        try {
            Class aClass = warWithParams.getClass();
            Method privateMethod = aClass.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(warWithParams);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Class<Hero> heroClass = Hero.class;
        reflection.getClassFields(heroClass);
        reflection.getClassMethods(heroClass);
    }
}