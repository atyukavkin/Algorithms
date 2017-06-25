package com.wiley.algorithms;

import com.wiley.algorithms.searching.BinarySearcher;
import com.wiley.algorithms.sortings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Andrey Tyukavkin on 4/7/2017.
 * Demonstration
 */
public class Demonstrator {

    public static void main(String[] args) {
        int typeOfAlgorithm = 0;
        if (args == null || args.length == 0) {
            System.out.println("Type of sorting is not set");
            return;
        }
        String typeOfAlgorithmArgument = args[0];
        try {
            typeOfAlgorithm = Integer.parseInt(typeOfAlgorithmArgument);
        } catch (NumberFormatException e) {
            System.out.println("Wrong type of algorithm " + typeOfAlgorithmArgument);
        }

        Comparable[] input = readInput();

        if (input.length > 0 && args.length == 1) {
            performSortingAlgorithm(typeOfAlgorithm, input);
        } else if (input.length > 0 && args.length == 2) {
            String searchKeywordArgument = args[1];
            try {
                int keyword = Integer.parseInt(searchKeywordArgument);
                performSearchingAlgorithm(typeOfAlgorithm, keyword, input);
            } catch (NumberFormatException e) {
                System.out.println("Wrong type of algorithm " + typeOfAlgorithmArgument);
            }
        }
    }

    private static void performSearchingAlgorithm(int typeOfAlgorithm, Comparable keyword, Comparable[] input) {
        int position = 0;

        switch (typeOfAlgorithm) {
            case 11:
                QuickSorter quickSorter = new QuickSorter();
                Comparable[] output = quickSorter.sort(input);
                System.out.println("Sorted input list");
                printList(output);

                BinarySearcher binarySearcher = new BinarySearcher();
                position = binarySearcher.search(output, keyword);
                System.out.println(binarySearcher.toString());
                break;
            default:
                System.out.println("Wrong type of searching " + typeOfAlgorithm);
                break;
        }
        if (position <= 0) {
            System.out.println("Keyword is not found");
        } else {
            System.out.println("Position of keyword is " + position);
        }
    }

    private static void performSortingAlgorithm(int typeOfAlgorithm, Comparable[] input) {
        System.out.println("Not sorted list");
        printList(input);
        Comparable[] output = null;

        switch (typeOfAlgorithm) {
            case 1:
                BubbleSorter bubbleSorter = new BubbleSorter();
                output = bubbleSorter.sort(input);
                System.out.println(bubbleSorter.toString());
                break;
            case 2:
                MergeSorter mergeSorter = new MergeSorter();
                output = mergeSorter.sort(input);
                System.out.println(mergeSorter.toString());
                break;
            case 3:
                SelectionSorter selectionSorter = new SelectionSorter();
                output = selectionSorter.sort(input);
                System.out.println(selectionSorter.toString());
                break;
            case 4:
                QuickSorter quickSorter = new QuickSorter();
                output = quickSorter.sort(input);
                System.out.println(quickSorter.toString());
                break;
            case 5:
                HeapSorter heapSorter = new HeapSorter();
                output = heapSorter.sort(input);
                System.out.println(heapSorter.toString());
                break;
            default:
                System.out.println("Wrong type of sorting " + typeOfAlgorithm);
                break;
        }
        if (output != null) {
            System.out.println("Sorted list");
            printList(output);
        }
    }

    private static Comparable[] readInput() {
        System.out.println("Enter comma separated list of numbers 1,3,4,5 ");
        Scanner reader = new Scanner(System.in);
        reader.useDelimiter(",");
        List<Comparable> inputList = new ArrayList<>();
        while (reader.hasNext()) {
            String next = reader.next();

            if (".".equals(next)) {
                reader.close();
            }

            try {
                inputList.add(Integer.parseInt(next));
            } catch (NumberFormatException e) {
                System.out.println("Skipped not a number element " + next);
            }
        }
        Comparable[] input = new Comparable[inputList.size()];
        input = inputList.toArray(input);

        System.out.println("Finished to read");
        return input;
    }

    private static void printList(Comparable[] toPrint) {
        for (Comparable aResult : toPrint) {
            System.out.print(aResult + ", ");
        }
        System.out.println("");
    }
}
