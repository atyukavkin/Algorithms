package com.wiley.sorting.algorithms;

/**
 * Created by Andrey Tyukavkin on 4/9/2017.
 *
 */
public class MergeSorter<T extends Comparable<T>> implements Sorting<T> {

    public T[] sort(T[] input) {
        Comparable[] tempMerge = new Comparable[input.length];
        mergeSort(input, tempMerge, 0, input.length - 1);
        return input;
    }

    private void mergeSort(T[] input, Comparable[] tempMerge, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = (lowerIndex + higherIndex) / 2;
            mergeSort(input, tempMerge, lowerIndex, middle);
            mergeSort(input, tempMerge, middle + 1, higherIndex);
            mergeParts(input, tempMerge, lowerIndex, middle + 1, higherIndex);
        }
    }

    private void mergeParts(T[] input, Comparable[] tempMerge, int lowerIndex, int middle, int higherIndex) {

        int leftEnd = middle - 1;
        int k = lowerIndex;
        int num = higherIndex - lowerIndex + 1;

        while (lowerIndex <= leftEnd && middle <= higherIndex) {
            if (input[lowerIndex].compareTo(input[middle]) <= 0) {
                tempMerge[k++] = input[lowerIndex++];
            } else {
                tempMerge[k++] = input[middle++];
            }
        }

        while (lowerIndex <= leftEnd) {
            tempMerge[k++] = input[lowerIndex++];
        }

        while (middle <= higherIndex) {
            tempMerge[k++] = input[middle++];
        }

        for (int i = 0; i < num; i++, higherIndex--) {
            input[higherIndex] = (T) tempMerge[higherIndex];
        }
    }
}