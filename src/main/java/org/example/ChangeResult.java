package org.example;

import java.util.List;

public class ChangeResult {
    private final int startIndex;
    private final int size;
    private final List<Integer> part;

    public ChangeResult(int startIndex, int size, List<Integer> part) {
        this.startIndex = startIndex;
        this.size = size;
        this.part = part;
    }

    public void printPart() {
        for (int i = startIndex; i < startIndex + size; i++) {
            System.out.println(part.get(i));
        }
        System.out.println("size is " + size);
        System.out.println();
    }
}
