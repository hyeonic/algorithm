package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Scanner;

public class BOJ9093 {

    private static String reverse(String word) {

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = word.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] words = scanner.nextLine().split(" ");
            for (String word : words) {
                stringBuilder.append(reverse(word)).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}