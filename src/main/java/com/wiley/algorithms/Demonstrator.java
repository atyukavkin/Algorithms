package com.wiley.algorithms;

import com.wiley.algorithms.sortings.BubbleSorter;
import com.wiley.algorithms.sortings.MergeSorter;
import com.wiley.algorithms.sortings.QuickSorter;
import com.wiley.algorithms.sortings.SelectionSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Andrey Tyukavkin on 4/7/2017.
 *
 */
public class Demonstrator {

    public static void main(String[] args) {
        int typeOfSorting = 0;
        if (args == null || args.length == 0) {
            System.out.println("Type of sorting is not set");
            return;
        }
        String typeOfSortingArgument = args[0];
        try {
            typeOfSorting = Integer.parseInt(typeOfSortingArgument);
        } catch (NumberFormatException e) {
            System.out.println("Wrong type of sorting " + typeOfSortingArgument);
        }

        Comparable[] input = readInput();

        if (input.length > 0) {
            makeSorting(typeOfSorting, input);
        }
    }

    private static void makeSorting(int typeOfSorting, Comparable[] input) {
        System.out.println("Not sorted list");
        printList(input);
        Comparable[] output = null;

        switch (typeOfSorting) {
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
            default:
                System.out.println("Wrong type of sorting " + typeOfSorting);
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
