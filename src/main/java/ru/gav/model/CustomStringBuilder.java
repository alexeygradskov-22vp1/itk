package ru.gav.model;

import ru.gav.snapshot.Snapshot;


public class CustomStringBuilder {
    private char[] buffer;
    private int size;
    private Snapshot previousState;

    private static final int INITIAL_CAPACITY = 16;

    public CustomStringBuilder() {
        buffer = new char[INITIAL_CAPACITY];
        size = 0;
    }

    public CustomStringBuilder(String str) {
        buffer = new char[Math.max(INITIAL_CAPACITY, str.length())];
        size = 0;
        append(str);
    }

    public CustomStringBuilder append(String str) {
        savePreviousState();
        if (str == null) str = "null";
        ensureCapacity(size + str.length());
        for (int i = 0; i < str.length(); i++) {
            buffer[size++] = str.charAt(i);
        }
        return this;
    }

    public CustomStringBuilder append(char c) {
        savePreviousState();
        ensureCapacity(size + 1);
        buffer[size++] = c;
        return this;
    }

    public int length() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity <= buffer.length) return;

        int newCapacity = buffer.length * 2;
        while (newCapacity < minimumCapacity) {
            newCapacity *= 2;
        }

        char[] newBuffer = new char[newCapacity];
        System.arraycopy(buffer, 0, newBuffer, 0, size);
        buffer = newBuffer;
    }

    @Override
    public String toString() {
        return new String(buffer, 0, size);
    }

    public CustomStringBuilder undo() {
        this.buffer = previousState.getBufferState();
        this.size = previousState.getSizeState();
        return this;
    }

    private void savePreviousState() {
        this.previousState = Snapshot.create(buffer, size);
    }

}
