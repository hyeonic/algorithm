package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ10610 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        List<String> numbers = new ArrayList<>(Arrays.asList(number.split("")));

        numbers.sort(Comparator.reverseOrder());

        int sum = numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();

        if (numbers.contains("0") && sum % 3 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : numbers) {
                stringBuilder.append(s);
            }

            System.out.println(stringBuilder);
        } else {
            System.out.println("-1");
        }
    }
}