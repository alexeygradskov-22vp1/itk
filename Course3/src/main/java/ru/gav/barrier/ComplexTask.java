package ru.gav.barrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class ComplexTask implements Runnable {
    private final int taskId;
    private final CyclicBarrier cyclicBarrier;
    private final ResultCollector resultCollector;
    private int result;

    public ComplexTask(int taskId, CyclicBarrier cyclicBarrier, ResultCollector resultCollector) {
        this.taskId = taskId;
        this.cyclicBarrier = cyclicBarrier;
        this.resultCollector = resultCollector;
    }


    @Override
    public void run() {
        try {
            result = new Random().nextInt(100);
            resultCollector.addResult(result);
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
