package org.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StatisticsCalculator {
    private final List<Integer> intList;

    public StatisticsCalculator(List<Integer> intList) {
        this.intList = intList;
    }

    public int getMin() {
        return Collections.min(intList);
    }

    public int getMax() {
        return Collections.max(intList);
    }

    public Integer getMedian() {
        List<Integer> sortedIntList = new LinkedList<>(intList);
        Collections.sort(sortedIntList);
        if (sortedIntList.size() % 2 != 0) {
            return sortedIntList.get(sortedIntList.size() / 2);
        }
        return (sortedIntList.get(sortedIntList.size() / 2)
                + sortedIntList.get((sortedIntList.size() / 2) + 1)) / 2;
    }

    public double getAverage() {
        return intList.stream().mapToDouble(num -> num).average().getAsDouble();
    }
}
