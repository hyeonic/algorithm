package me.hyeonic.algorithm.thisiscodingtest.chapter04;

import java.util.Scanner;

public class Example4_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();

        int cnt = 0;
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String time = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    if (time.contains("3")) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}

/*
input
5

output
11475
*/