package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Scanner;

public class BOJ1924 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month = scanner.nextInt();
        int day = scanner.nextInt();

        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int totalDay = day;
        for (int i = 1; i < month; ++i) {
            totalDay += days[i];
        }

        System.out.println(weeks[totalDay % 7]);
    }
}