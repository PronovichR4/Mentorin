package by.epam.pronovich.homework01.task07;

import by.epam.pronovich.homework01.task07.annotation.ProdCode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

    public static void main(String[] args) {

        ProRunner proRunner = new ProRunner();
        Class<? extends ProRunner> aClass = proRunner.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(ProdCode.class)) {
                declaredMethod.setAccessible(true);
                try {
                    declaredMethod.invoke(proRunner);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}