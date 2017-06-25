package com.wiley.algorithms.searching;

/**
 * Created by Andrey Tyukavkin on 4/11/2017.
 * Binary search
 */
public class BinarySearcher<T extends Comparable<T>> implements Searching<T> {
    @Override
    public int search(T[] input, T keyword) {
        if (input.length == 0) {
            return -1;
        }

        int low = 0;
        int high = input.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (keyword.compareTo(input[middle]) > 0) {
                low = middle + 1;
            } else if (keyword.compareTo(input[middle]) < 0) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Binary searching";
    }
}
