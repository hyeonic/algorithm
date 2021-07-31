package me.hyeonic.algorithm.thisiscodingtest.chapter07;

import java.util.Arrays;
import java.util.Scanner;

public class Practice7_5 {

    static int[] numbers;

    private static boolean binarySearch(int target, int start, int end) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if (numbers[mid] == target) {
            return true;
        } else if (numbers[mid] > target) {
            return binarySearch(target, start, mid - 1);
        } else {
            return binarySearch(target, mid + 1, end);
        }
    }

    private static boolean binarySearchV2(int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (numbers[mid] == target) {
                return true;
            } else if (numbers[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            if (binarySearch(scanner.nextInt(), 0, n - 1)) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}

/*
입력
5
8 3 7 9 2
3
5 7 9

출력
no yes yes
*/