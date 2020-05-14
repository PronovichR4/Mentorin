package by.epam.pronovich.homework01.task05.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;


@Repeatable(ThisCodeSmellsContainer.class)
@Target(value = {CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
public @interface ThisCodeSmells {
    public String reviewer();
}
