package me.hyeonic.algorithm.thisiscodingtest.chapter06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Practice6_12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // 배열 A는 오름차순 정렬
        Arrays.sort(a);
        // 배열 B는 내림차순 정렬
        Arrays.sort(b, Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            } else {
                break;
            }
        }

        // 배열 A의 모든 원소의 합 출력
        int sum = Arrays.stream(a)
                .mapToInt(value -> Integer.valueOf(value))
                .sum();

        System.out.println(sum);
    }
}

/*
입력
5 3
1 2 5 4 3
5 5 6 6 5

출력
26
*/