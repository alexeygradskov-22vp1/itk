package ru.gav.barrier;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ResultCollector {
    private final List<Integer> results = Collections.synchronizedList(new LinkedList<>());

    public void addResult(int result) {
        results.add(result);
    }

    public List<Integer> getResults() {
        return results;
    }

    public int getTotal() {
        return results.stream().mapToInt(Integer::intValue).sum();
    }
}

