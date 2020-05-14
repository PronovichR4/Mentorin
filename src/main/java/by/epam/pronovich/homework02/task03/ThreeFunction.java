package by.epam.pronovich.homework02.task03;

@FunctionalInterface
public interface ThreeFunction<T, U, F, R> {

    R apply(T t, U u, F f);
}
