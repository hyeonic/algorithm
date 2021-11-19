package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2110 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 집의 개수
        int c = scanner.nextInt(); // 공유기의 개수
        int[] homes = new int[n];

        for (int i = 0; i < n; i++) {
            homes[i] = scanner.nextInt();
        }

        Arrays.sort(homes);

        int left = 1;
        int right = homes[n - 1] - homes[0];

        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int start  = homes[0];
            int count = 1;

            for (int i = 0; i < n; i++) {
                if (homes[i] - start >= mid) {
                    count++;
                    start = homes[i];
                }
            }

            if (count >= c) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}