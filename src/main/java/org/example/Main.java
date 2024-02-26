package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> intList = readIntegersFromFile();
        findAndPrintBiggestSequence(intList, true);
        findAndPrintBiggestSequence(intList, false);
        printStatistics(intList);
    }

    private static List<Integer> readIntegersFromFile() {
        System.out.println("please enter your file name");
        String fileName = sc.nextLine();
        try {
            File file = new File(fileName);
            return Files.readAllLines(file.toPath()).stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("can't read or find file", e);
        }
    }

    private static void findAndPrintBiggestSequence(List<Integer> intList, boolean decreasing) {
        SequenceAnalyzer changeFinder = new SequenceAnalyzer();
        ChangeResult result = decreasing
                ? changeFinder.findDecreasing(intList)
                : changeFinder.findIncreasing(intList);

        System.out.println(decreasing
                ? "Biggest decrease part"
                : "Biggest increase part");
        result.printPart();
    }

    private static void printStatistics(List<Integer> intList) {
        StatisticsCalculator calculator = new StatisticsCalculator(intList);
        System.out.println("Min value is: " + calculator.getMin());
        System.out.println("Max value is: " + calculator.getMax());
        System.out.println("Median: " + calculator.getMedian());
        System.out.println("Average: " + calculator.getAverage());
    }
}