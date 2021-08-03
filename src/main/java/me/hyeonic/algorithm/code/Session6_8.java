package me.hyeonic.algorithm.code;

import java.util.Arrays;
import java.util.Scanner;

public class Session6_8 {

    static int[] numbers;

    private static int binarySearch(int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (numbers[mid] == target) {
                return mid + 1;
            } else if (numbers[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        System.out.println(binarySearch(m, 0, n - 1));
    }
}