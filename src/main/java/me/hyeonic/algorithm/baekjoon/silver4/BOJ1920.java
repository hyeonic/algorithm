package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1920 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int m = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int number = scanner.nextInt();
            if (Arrays.binarySearch(numbers, number) >= 0) {
                stringBuilder.append("1").append("\n");
            } else {
                stringBuilder.append("0").append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}

class BOJ1920v2 {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int m = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int number = scanner.nextInt();
            if (binarySearch(number, 0, n - 1)) {
                stringBuilder.append("1").append("\n");
            } else {
                stringBuilder.append("0").append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}

class BOJ1920v3 {

    static int[] numbers;

    private static boolean binarySearch(int target, int start, int end) {
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

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int number = scanner.nextInt();
            if (binarySearch(number, 0, n - 1)) {
                stringBuilder.append("1").append("\n");
            } else {
                stringBuilder.append("0").append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}