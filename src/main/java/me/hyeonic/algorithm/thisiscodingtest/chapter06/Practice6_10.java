package me.hyeonic.algorithm.thisiscodingtest.chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Practice6_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.stream(numbers)
                .sorted(Collections.reverseOrder())
                .forEach(value -> System.out.print(value + " "));
    }
}

/*
입력
3
15
27
12

출력
27 15 12
*/