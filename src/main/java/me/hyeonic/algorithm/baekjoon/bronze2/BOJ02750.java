package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ02750 {

    private static int n;
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        mergeSort(0, n - 1);

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static void mergeSort(int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    private static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int index = left;

        int[] sortedNumbers = new int[n];
        while (l <= mid && r <= right) {
            if (numbers[l] <= numbers[r]) {
                sortedNumbers[index] = numbers[l];
                index++;
                l++;
                continue;
            }

            sortedNumbers[index] = numbers[r];
            index++;
            r++;
        }

        while (r <= right) {
            sortedNumbers[index] = numbers[r];
            index++;
            r++;
        }

        while (l <= mid) {
            sortedNumbers[index] = numbers[l];
            index++;
            l++;
        }

        for (int i = left; i <= right; i++) {
            numbers[i] = sortedNumbers[i];
        }
    }
}
