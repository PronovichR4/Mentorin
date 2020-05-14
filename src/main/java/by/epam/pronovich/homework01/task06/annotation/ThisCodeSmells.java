package by.epam.pronovich.homework01.task06.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


@Repeatable(ThisCodeSmellsContainer.class)
@Target(value = {CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThisCodeSmells {
    public String reviewer();
}
