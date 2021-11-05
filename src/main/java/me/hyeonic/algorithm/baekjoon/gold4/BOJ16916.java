package me.hyeonic.algorithm.baekjoon.gold4;

import java.util.Scanner;

public class BOJ16916 {

    private static int count;

    private static void kmp(String origin, String pattern) {
        int[] pi = getPi(pattern);
        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    ++count;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }

    private static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String origin = scanner.next();
        String pattern = scanner.next();

        kmp(origin, pattern);

        if (count > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}