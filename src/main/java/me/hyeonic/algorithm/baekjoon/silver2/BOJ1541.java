package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Scanner;

public class BOJ1541 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split("-");

        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            int num = 0;
            for (String s : split[i].split("\\+")) {
                num += Integer.parseInt(s);
            }

            sum = i == 0 ? num : sum - num;
        }

        System.out.println(sum);
    }
}