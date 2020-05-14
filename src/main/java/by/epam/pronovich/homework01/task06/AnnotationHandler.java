package by.epam.pronovich.homework01.task06;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationHandler {

    public void printClassUsedAnotat(List<Class<?>> classes, Class<? extends Annotation> annotation) {
        for (Class aClass : classes) {
            if (aClass.isAnnotationPresent(annotation)) {
                Method[] methods = annotation.getMethods();
                System.out.println(aClass.getName());
            }
        }
    }

    public void printMethodUsedAnotat(List<Class<?>> classes, Class<? extends Annotation> annotation) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Class aClass : classes) {
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(annotation)) {
                    System.out.println(aClass.getName() + " " + method.getName());
                }
            }
        }
    }

    public void printFieldUsedAnotat(List<Class<?>> classes, Class<? extends Annotation> annotation) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Class aClass : classes) {
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
               if(field.isAnnotationPresent(annotation)){
                   System.out.println(aClass.getName()+" "+field.getName());
               }
            }
        }
    }
}



