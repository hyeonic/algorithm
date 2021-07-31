package me.hyeonic.algorithm.thisiscodingtest.chapter07;

import java.util.Scanner;

public class Practice7_8 {

    static int n, m;
    static int[] heights;

    private static int binarySearch(int start, int end) {
        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                if (heights[i] > mid) {
                    total += heights[i] - mid;
                }
            }

            if (total < m) {
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

        n = scanner.nextInt();
        m = scanner.nextInt();

        heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        System.out.println(binarySearch(0, (int) 1e9));
    }
}

/*
입력
4 6
19 15 10 17

출력
15
*/