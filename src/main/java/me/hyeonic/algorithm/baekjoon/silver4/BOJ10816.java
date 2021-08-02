package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ10816 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            numbers.put(number, numbers.getOrDefault(number, 0) + 1);
        }

        int m = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int number = scanner.nextInt();
            stringBuilder.append(numbers.getOrDefault(number, 0)).append(" ");
        }

        System.out.println(stringBuilder);
    }
}