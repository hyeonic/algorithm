package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1931 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 회의의 수
        int[][] conferences = new int[n][2];

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] times = scanner.nextLine().split(" ");
            String startTime = times[0];
            String endTime = times[1];
            conferences[i][0] = Integer.valueOf(startTime);
            conferences[i][1] = Integer.valueOf(endTime);
        }

        Arrays.sort(conferences, (x, y) -> {
            if (x[0] > y[0]) {
                return 1;
            } else if (x[0] == y[0]) {
                return 0;
            }
            return -1;
        });

        Arrays.sort(conferences, (x, y) -> {
            if (x[1] > y[1]) {
                return 1;
            } else if (x[1] == y[1]) {
                return 0;
            }
            return -1;
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