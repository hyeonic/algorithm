package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class BOJ1476 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputE = scanner.nextInt();
        int inputS = scanner.nextInt();
        int inputM = scanner.nextInt();

        int year = 1;
        int e = 1, s = 1, m = 1;
        while (true) {
            if (inputE == e && inputS == s && inputM == m) {
                break;
            }

            e++;
            s++;
            m++;
            if (e == 16) {
                e = 1;
            }

            if (s == 29) {
                s = 1;
            }

            if (m == 20) {
                m = 1;
            }

            year++;
        }

        System.out.println(year);
    }
}