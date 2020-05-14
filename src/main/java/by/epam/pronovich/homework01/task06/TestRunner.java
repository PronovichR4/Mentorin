package by.epam.pronovich.homework01.task06;


import by.epam.pronovich.homework01.task06.annotation.ProdCode;
import by.epam.pronovich.homework01.task06.annotation.ThisCodeSmells;
import by.epam.pronovich.homework01.task06.annotation.UseArrayList;
import by.epam.pronovich.homework01.task06.hierarchy.Archer;
import by.epam.pronovich.homework01.task06.hierarchy.Hero;
import by.epam.pronovich.homework01.task06.hierarchy.Warrior;

import java.lang.reflect.Method;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) throws ClassNotFoundException {

        AnnotationHandler annotationHandler = new AnnotationHandler();

        List<Class<?>> classes = ClassFinder.find("main.java.by.epam.pronovich.homework01.task06.hierarchy");
        annotationHandler.printClassUsedAnotat(classes, ThisCodeSmells.class);
        annotationHandler.printMethodUsedAnotat(classes, ProdCode.class);
        annotationHandler.printFieldUsedAnotat(classes, ThisCodeSmells.class);
    }


}
