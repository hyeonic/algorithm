package me.hyeonic.algorithm.thisiscodingtest.chapter07;

import java.util.Scanner;

public class Practice7_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        boolean[] numbers = new boolean[1_000_001];
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            numbers[number] = true;
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            if (numbers[scanner.nextInt()]) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}

/*
입력
5
8 3 7 9 2
3
5 7 9

출력
no yes yes
*/