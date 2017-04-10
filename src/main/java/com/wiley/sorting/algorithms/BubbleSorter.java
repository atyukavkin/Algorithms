package com.wiley.sorting.algorithms;

/**
 * Created by Andrey Tyukavkin on 4/9/2017.
 *
 */
public class BubbleSorter<T extends Comparable<T>> implements Sorting<T> {

    private static void swapPositions(int i, int j, Comparable[] input) {
        Comparable temp;
        temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public T[] sort(T[] input) {
        int inputSize = input.length;
        for (int i = inputSize; i >= 0; i--) {
            for (int k = 0; k < inputSize - 1; k++) {
                if (input[k].compareTo(input[k + 1]) > 0) {
                    swapPositions(k, k + 1, input);
                }
            }
        }
        return input;
    }

}


