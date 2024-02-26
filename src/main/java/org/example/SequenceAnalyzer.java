package org.example;

import java.util.List;

public class SequenceAnalyzer {
    public ChangeResult findDecreasing(List<Integer> intList) {
        int size = 0;
        int max_size = 0;
        int start_index = 0;
        for (int i = 0; i < intList.size() - 1; i++) {
            if (intList.get(i) > intList.get(i+1)) {
                size++;
            }
            else {
                if (size > max_size) {
                    max_size = size;
                    start_index = i - size;
                }
                size = 0;
            }
        }
        return new ChangeResult(start_index, max_size, intList);
    }

    public ChangeResult findIncreasing(List<Integer> intList) {
        int size = 0;
        int max_size = 0;
        int start_index = 0;
        for (int i = 0; i < intList.size() - 1; i++) {
            if (intList.get(i) < intList.get(i+1)) {
                size++;
            } else {
                if (size > max_size) {
                    max_size = size;
                    start_index = i - size;
                }
                size = 0;
            }
        }
        return new ChangeResult(start_index, max_size, intList);
    }
}
