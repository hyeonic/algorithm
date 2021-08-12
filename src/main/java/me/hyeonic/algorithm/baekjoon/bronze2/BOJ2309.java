package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] heights = new int[9];

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            heights[i] = scanner.nextInt();
            sum += heights[i];
        }

        int liar1 = 0;
        int liar2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (100 == sum - (heights[i] + heights[j])) {
                    liar1 = heights[i];
                    liar2 = heights[j];

                    Arrays.sort(heights);
                    for (int k = 0; k < 9; k++) {
                        if (heights[k] == liar1 || heights[k] == liar2) {
                            continue;
                        } else {
                            System.out.println(heights[k]);
                        }
                    }
                    return;
                }
            }
        }
    }
}