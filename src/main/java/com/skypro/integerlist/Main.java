package com.skypro.integerlist;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntegerService service = new IntegerService(100000);
        Integer[] integers = generateRandomArray();
        Integer[] integers4 = Arrays.copyOf(integers, 100000);
        long start4 = System.currentTimeMillis();
        service.mergeSort(integers4);
        long test4 = System.currentTimeMillis() - start4;
        System.out.println("Time for mergeSort: " + test4);
    }

    private static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}
