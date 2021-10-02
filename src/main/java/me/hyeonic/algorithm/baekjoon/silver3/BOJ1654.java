package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ1654 {

    static int k, n;
    static int[] lengths;

    private static long binarySearch(long start, long end) {
        long result = 0;
        while (start <= end) {
            int total = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < k; i++) {
                total += (lengths[i] / mid);
            }

            if (total < n) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        k = scanner.nextInt(); // 랜선의 개수
        n = scanner.nextInt(); // 필요한 랜선의 개수

        lengths = new int[k];
        for (int i = 0; i < k; i++) {
            lengths[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int length : lengths) {
            max = Math.max(max, length);
        }

        System.out.println(binarySearch(1, max));
    }
}