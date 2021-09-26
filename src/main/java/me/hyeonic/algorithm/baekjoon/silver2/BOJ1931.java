package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1931 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 회의의 수
        int[][] conferences = new int[n][2];

        for (int i = 0; i < n; i++) {
            conferences[i][0] = scanner.nextInt();
            conferences[i][1] = scanner.nextInt();
        }

        Arrays.sort(conferences, (o1, o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] == o2[1] && o1[0] < o2[0]) {
                return -1;
            } else if (o1[1] == o2[1] && o1[0] == o2[0]) {
                return 0;
            }
            return 1;
        });

        int count = 1;
        int tempEndTime = conferences[0][1];
        for (int i = 1; i < n; i++) {
            if (tempEndTime <= conferences[i][0]) {
                count++;
                tempEndTime = conferences[i][1];
            }
        }

        System.out.println(count);
    }
}