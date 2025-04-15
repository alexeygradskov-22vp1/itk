package ru.gav;

import ru.gav.counter.CollectionCounter;

import java.util.List;

import static ru.gav.service.ArraySupplier.filter;


public class Main {

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 5};

        Integer[] result = filter(input,
                t -> t + 2, Integer[]::new);

        for (Integer i : result) {
            System.out.println(i);
        }

        List<Integer> numbers = List.of(1, 2, 1, 2, 1, 1);
        CollectionCounter counter = new CollectionCounter();
        var counted = counter.countOfEls(numbers);
        counted.entrySet().stream().forEach((k) -> System.out.println(k.getKey() + " = " + k.getValue()));
    }
}
