package com.wiley.algorithms.sortings;

/**
 * Created by Andrey Tyukavkin on 6/25/2017.
 */
public class HeapSorter<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public T[] sort(T[] input) {
        int n = input.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(input, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            T temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            heapify(input, i, 0);
        }
        return input;
    }

    private void heapify(T[] input, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && input[left].compareTo(input[largest]) > 0) {
            largest = left;
        }
        if (right < n && input[right].compareTo(input[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            T swap = input[i];
            input[i] = input[largest];
            input[largest] = swap;
            heapify(input, n, largest);
        }
    }

    @Override
    public String toString() {
        return "Heap sorting";
    }
}
