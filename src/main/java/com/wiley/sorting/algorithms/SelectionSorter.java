package com.wiley.sorting.algorithms;

/**
 * Created by Andrey Tyukavkin on 4/9/2017.
 */
public class SelectionSorter<T extends Comparable<T>> implements Sorting<T> {

    public T[] sort(T[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j].compareTo(input[index]) < 0) {
                    index = j;
                }
            }
            T minimum = input[index];
            input[index] = input[i];
            input[i] = minimum;
        }

        return input;
    }
}
