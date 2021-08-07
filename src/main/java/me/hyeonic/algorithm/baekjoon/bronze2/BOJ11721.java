package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ11721 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            stringBuilder.append(c);
            count++;

            if (count == 10) {
                stringBuilder.append("\n");
                count = 0;
            }
        }

        System.out.println(stringBuilder);
    }
}