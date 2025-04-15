package ru.gav.service;

import ru.gav.filter.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

public class ArraySupplier {

    public static <T> T[] filter(T[] array, Filter<T> filter, IntFunction<T[]> generator) {
        List<T> tempList = new ArrayList<>();
        for (T t : array) {
            T result = filter.apply(t);
            if (result != null) {
                tempList.add(result);
            }
        }
        return tempList.toArray(generator.apply(tempList.size()));
    }
}
