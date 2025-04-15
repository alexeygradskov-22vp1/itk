package ru.gav.counter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionCounter {

    public <T> Map<T, Integer> countOfEls(Collection<T> collection) {
        return collection
                .stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.collectingAndThen(Collectors.toList(), List::size) // подсчет каждого элемента
                ));
    }
}
