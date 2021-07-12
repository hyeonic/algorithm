package me.hyeonic.algorithm.thisiscodingtest.chapter03;

import java.util.Scanner;

public class Practice3_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int result = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, sc.nextInt());
            }
            result = Math.max(min, result);
        }

        System.out.println(result);
    }
}
/*
input
3 3
3 1 2
4 1 4
2 2 2

output
2

input
2 4
7 3 1 8
3 3 3 4

output
3
*/