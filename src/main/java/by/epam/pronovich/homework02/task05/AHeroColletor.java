package by.epam.pronovich.homework02.task05;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AHeroColletor implements Collector<AHero, List<Integer>, Integer> {

    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, AHero> accumulator() {
        return (it, el) -> it.add(el.getHealth());
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (l, r) -> {
            l.addAll(r);
            return l;
        };
    }

    @Override
    public Function<List<Integer>, Integer> finisher() {
        return (it) -> it.stream().filter(el -> el > 100).collect(Collectors.toList()).size();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.UNORDERED);
    }


}
