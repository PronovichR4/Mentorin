package by.epam.pronovich.homework02.task02;

@FunctionalInterface
public interface SettableFuncInterface<T> {

    void set(T obj, String name, int age);

    default String defaultMethod() {
        return "Default method";
    }

    static String staticMethod() {
        return "Static method";
    }
}
