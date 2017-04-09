package com.wiley.sorting.algorithms;

import java.util.List;

public class NumberBubbleSorter implements Sorting<Integer> {

    private static void swapPositions(int i, int j, List<Integer> input) {
        Integer temp;
        temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }

    public List<Integer> sort(List<Integer> input) {
        int inputSize = input.size();
        for (int i = inputSize; i >= 0; i--) {
            for (int k = 0; k < inputSize - 1; k++) {
                if (input.get(k) > input.get(k + 1)) {
                    swapPositions(k, k + 1, input);
                }
            }
        }
        return input;
    }
}
