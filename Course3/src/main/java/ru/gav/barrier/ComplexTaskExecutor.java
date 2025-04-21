package ru.gav.barrier;

import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final int numberOfTasks;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public void execute(int numberOfTasks){
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);
        ResultCollector collector = new ResultCollector();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfTasks,()->{
            System.out.println("Потоки завершены");
        });

        for (int i=0; i<numberOfTasks;i++){
            executorService.submit(new ComplexTask(i, cyclicBarrier, collector));
        }
        executorService.shutdown();
        try{
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        }catch (InterruptedException e){
            System.out.println("TIMED OUT");
        }
    }
}
