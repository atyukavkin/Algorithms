package com.wiley.algorithms.sortings;

/**
 * Created by Andrey Tyukavkin on 4/10/2017.
 *
 */
public class QuickSorter<T extends Comparable<T>> implements Sorting<T> {

    public T[] sort(T[] input) {
        quickSort(input, 0, input.length - 1);
        return input;
    }

    private int partition(T[] input, int left, int right) {
        int i = left, j = right;
        T tmp;
        T pivot = input[(left + right) / 2];

        while (i <= j) {
            while (input[i].compareTo(pivot) < 0) {
                i++;
            }
            while (input[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                tmp = input[i];
                input[i] = input[j];
                input[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    private void quickSort(T[] input, int left, int right) {
        int index = partition(input, left, right);
        if (left < index - 1) {
            quickSort(input, left, index - 1);
        }
        if (index < right) {
            quickSort(input, index, right);
        }
    }

    @Override
    public String toString() {
        return "Quick sorting";
    }
}
