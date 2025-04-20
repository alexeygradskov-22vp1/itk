package ru.gav;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {
    private final LinkedList<T> queue;
    private final int size;

    public BlockingQueue(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public synchronized boolean enqueue(T el) throws InterruptedException {
        while (queue.size() == size) {
            wait();
        }
        queue.add(el);
        notifyAll();
        return true;
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T item = queue.removeFirst();
        notifyAll();
        return item;
    }

}
