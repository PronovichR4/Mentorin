package by.epam.pronovich.homework01.task04;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

    // Use reflection to instantiate all object in client code via constructors without arguments
    public Object createObject(Class clazz){
        Object obj=null;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

   // Print out the metadata for all classes in application in human-readable format

    public void getClassFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Class fields");
        for (Field field : fields) {
            Class<?> fld = field.getType();
            System.out.println("Class name : " + field.getName());
            System.out.println("Class type : " + fld.getName());
        }
    }

    public void getClassMethods(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        System.out.println("Class methods");
        for (Method method : methods) {
            System.out.println("Method name : " + method.getName());
            System.out.println("Return type : " +
                    method.getReturnType().getName());
            Class<?>[] params = method.getParameterTypes();
            System.out.print("Parameters : ");
            for (Class<?> param : params)
                System.out.print(" " + param.getName());
            System.out.println();
        }
    }
}