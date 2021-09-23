package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1181 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        Arrays.sort(words, (x, y) -> {
            if (x.length() < y.length()) {
                return -1;
            } else if (x.length() == y.length()) {
                return x.compareTo(y);
            }
            return 1;
        });

        String prevWord = "";
        for (String word : words) {
            if (!prevWord.equals(word)) {
                System.out.println(word);
            }
            prevWord = word;
        }
    }
}