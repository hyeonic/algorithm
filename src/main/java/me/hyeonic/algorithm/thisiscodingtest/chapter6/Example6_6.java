package me.hyeonic.algorithm.thisiscodingtest.chapter6;

public class Example6_6 {

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};

        int[] count = new int[10]; // 0 ~ 9 모든 범위를 포함하는 배열 선언 (모든 값은 0으로 초기화)

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++; // 각 데이터에 해당하는 인덱스의 값 증가
        }

        for (int i = 0; i < count.length; i++) { // 배열에 기록된 정보 확인
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}