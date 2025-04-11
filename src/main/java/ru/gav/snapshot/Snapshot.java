package ru.gav.snapshot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Snapshot {
    private char[] bufferState;
    private int sizeState;

    public static Snapshot create(char[] bufferState, int sizeState) {
        return new Snapshot(bufferState, sizeState);
    }
}
