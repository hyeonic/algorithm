package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ2108 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int sum = Arrays.stream(numbers).sum();
        System.out.println((int) Math.round(sum / (double) n)); // 산술 평균

        System.out.println(numbers[n / 2]); // 중앙값

        int[] counts = new int[8_001];
        for (int number : numbers) {
            counts[number + 4000]++;
        }

        int max = Integer.MIN_VALUE;
        for (int count : counts) {
            if (count > max) {
                max = count;
            }
        }

        List<Integer> maxNumbers = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (max == counts[i]) {
                maxNumbers.add(i - 4000);
            }
        }

        int mode = 0;
        if (maxNumbers.size() == 1) {
            mode = maxNumbers.get(0);
        } else {
            maxNumbers.sort(null);
            mode = maxNumbers.get(1);
        }

        System.out.println(mode); // 최빈값

        int maxNumber = Arrays.stream(numbers).max().getAsInt();
        int minNumber = Arrays.stream(numbers).min().getAsInt();
        System.out.println(maxNumber - minNumber); // 범위
    }
}