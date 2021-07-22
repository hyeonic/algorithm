package me.hyeonic.algorithm.thisiscodingtest.chapter06;

import java.util.Arrays;

public class Example6_4 {

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) return; // 원소가 1개인 경우 종료
        int pivot = start; // 피벗은 첫 번째 원소
        int left = start + 1;
        int right = end;
        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을 때 까지 반복
            while (left <= end && array[left] <= array[pivot]) left++;
            // 피벗보다 작은 데이터를 찾을 때 까지 반복
            while (right > start && array[right] >= array[pivot]) right--;
            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if (left > right) {
                int temp = array[pivot];
                array[pivot] = array[right];
                array[right] = temp;
            } else { // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quickSort(array, start, right - 1);
        quickSort(array, right + 1, end);
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(array, 0, array.length - 1);

        Arrays.stream(array).sorted().forEach(s -> System.out.print(s + " "));
    }
}