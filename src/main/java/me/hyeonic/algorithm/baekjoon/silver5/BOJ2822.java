package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2822 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] scores = new int[8];
        for (int i = 0; i < 8; i++) {
            scores[i] = scanner.nextInt();
        }

        int[] copyScores = scores.clone();
        Arrays.sort(copyScores);

        int totalScore = 0;
        for (int i = 3; i < 8; i++) {
            totalScore += copyScores[i];
        }

        System.out.println(totalScore);

        int standard = copyScores[3];
        for (int i = 0; i < 8; i++) {
            if (standard <= scores[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}