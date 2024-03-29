package me.hyeonic.algorithm.thisiscodingtest.chapter07;

import java.util.Scanner;

public class Example7_3 {

    // 이진 탐색 소스코드 구현(반복문)
    private static int binarySearch(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            // 찾은 경우 중간 인덱스 반환
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
                end = mid - 1;
            } else {
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
        int n = scanner.nextInt();
        int target = scanner.nextInt();

        // 전체 원소 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 이진 탐색 수행 결과 출력
        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println(result + 1);
        }
    }
}

/*
입력
10 7
1 3 5 7 9 11 13 15 17 19

출력
4

입력
10 7
1 3 5 6 9 11 13 15 17 19

출력
원소가 존재하지 않습니다.
*/