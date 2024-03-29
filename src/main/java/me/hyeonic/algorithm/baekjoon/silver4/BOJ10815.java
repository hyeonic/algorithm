package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ10815 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numberCards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numberCards.add(scanner.nextInt());
        }

        Collections.sort(numberCards);

        int m = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int number = scanner.nextInt();
            if (Collections.binarySearch(numberCards, number) >= 0) {
                stringBuilder.append("1 ");
            } else {
                stringBuilder.append("0 ");
            }
        }
        System.out.println(stringBuilder);
    }
}

class BOJ10815v2 {

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
                stringBuilder.append("1 ");
            } else {
                stringBuilder.append("0 ");
            }
        }
        System.out.println(stringBuilder);
    }
}

class BOJ10815v3 {

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
                stringBuilder.append("1 ");
            } else {
                stringBuilder.append("0 ");
            }
        }
        System.out.println(stringBuilder);
    }
}