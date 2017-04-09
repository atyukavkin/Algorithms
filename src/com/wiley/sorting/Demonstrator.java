package com.wiley.sorting;

import com.wiley.sorting.algorithms.NumberBubbleSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andron on 4/7/2017.
 */
public class Demonstrator {

    private static void printList(List toPrint) {
        for (Object aResult : toPrint) {
            System.out.print(aResult + ", ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        System.out.println("Enter comma separated list of numbers 1,3,4,5. \n");
        Scanner reader = new Scanner(System.in);
        reader.useDelimiter(",");
        List<Integer> input = new ArrayList<>();
        while (reader.hasNext()) {
            String next = reader.next();

            if (".".equals(next)) {
                reader.close();
            }

            try {
                input.add(Integer.parseInt(next));
            } catch (NumberFormatException e) {
                System.out.println("Skipped not a number element \n" + next);
            }
        }
        System.out.println("Finished to read\n");
        if (input.size() > 0) {
            System.out.println("Not sorted list\n");
            printList(input);
            NumberBubbleSorter bubbleSorter = new NumberBubbleSorter();
            List<Integer> output = bubbleSorter.sort(input);
            System.out.println("Sorted list\n");
            printList(output);
        }
    }
}
