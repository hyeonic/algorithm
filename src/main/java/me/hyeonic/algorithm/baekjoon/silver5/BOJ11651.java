package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11651 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] locations = new int[n][2];
        for (int i = 0; i < n; i++) {
            locations[i][0] = scanner.nextInt();
            locations[i][1] = scanner.nextInt();
        }

        Arrays.sort(locations, (o1, o2) -> {

            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        for (int[] location : locations) {
            System.out.println(location[0] + " " + location[1]);
        }
    }
}