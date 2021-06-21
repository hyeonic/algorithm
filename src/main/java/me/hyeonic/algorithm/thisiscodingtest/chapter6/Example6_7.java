package me.hyeonic.algorithm.thisiscodingtest.chapter6;

import java.util.Arrays;

public class Example6_7 {

    public static void main(String[] args) {

        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 8};

        Arrays.sort(array);
        Arrays.stream(array).forEach(value -> System.out.println(value + " "));
    }
}