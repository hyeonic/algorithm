package me.hyeonic.algorithm.notionexample;

import java.util.Arrays;
import java.util.Scanner;

public class DivideAndConquer {

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

        System.out.println(Arrays.toString(numbers));
    }

    private static void mergeSort(int left, int right) {
        /*
         * left 와 right 가 동일하다는 것은 부분 리스트가 1개의 원소만 가지는 경우이다.
         * 더 이상 쪼갤 수 없기 때문에 return 한다.
         */
        if (left == right) {
            return;
        }

        /*
         * 절반의 위치를 가져온다.
         */
        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    private static void merge(int left, int mid, int right) {
        int l = left; // 왼쪽 부분 리스트의 시작점
        int r = mid + 1; // 오른쪽 부분 리스트의 시작점
        int index = left; // 채워넣을 배열의 index

        int[] sortedNumbers = new int[n];
        /*
         * 왼쪽과 오른쪽 배열의 크기를 비교하며 채워간다.
         */
        while (l <= mid && r <= right) {
            /*
             * 왼쪽 부분 리스트의 원소가 작거나 같은 경우 정렬된 배열에 넣고 index 를 증감한다.
             */
            if (numbers[l] <= numbers[r]) {
                sortedNumbers[index] = numbers[l];
                index++;
                l++;
                continue;
            }

            /*
             * 오른쪽 부분 리스트의 원소가 작을 경우 정렬된 배열에 넣고 index 를 증감한다.
             */
            sortedNumbers[index] = numbers[r];
            index++;
            r++;
        }

        /*
         * 왼쪽 부분 리스트가 모두 채워진 경우 오른쪽 부분 리스트의 남은 원소를 채워준다.
         * 이미 정렬되어 있기 때문에 단순히 index 를 증가시켜 채워주기만 하면 된다.
         */
        while (r <= right) {
            sortedNumbers[index] = numbers[r];
            index++;
            r++;
        }

        /*
         * 오른쪽 부분 리스트가 모두 채워진 경우 왼쪽 부분 리스트의 남은 원소를 채워준다.
         * 이미 정렬되어 있기 때문에 단순히 index 를 증가시켜 채워주기만 하면 된다.
         */
        while (l <= mid) {
            sortedNumbers[index] = numbers[l];
            index++;
            l++;
        }

        /*
         * 정렬된 배열을 옮겨준다.
         */
        for (int i = left; i <= right; i++) {
            numbers[i] = sortedNumbers[i];
        }
    }
}
