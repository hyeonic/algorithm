package me.hyeonic.algorithm.thisiscodingtest.chapter06;

import java.util.Arrays;

public class Example6_3 {

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < array.length; i++) {
            // 인덱스 i부터 1까지 감소하며 반복하는 문법
            for (int j = i; j > 0; j--) {
                // 한 칸씩 왼쪽으로 이동
                if (array[j] < array[j - 1]) {
                    // 스와프(Swap)
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
                    break;
                }
            }
        }

        Arrays.stream(array).forEach(s -> System.out.print(s + " "));
    }
}