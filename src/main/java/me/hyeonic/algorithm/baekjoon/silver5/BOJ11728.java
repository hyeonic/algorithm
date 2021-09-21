package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ11728 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            numbers.add(scanner.nextInt());
        }

        numbers.sort(null);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            stringBuilder.append(number).append(" ");
        }
        System.out.println(stringBuilder);
    }
}