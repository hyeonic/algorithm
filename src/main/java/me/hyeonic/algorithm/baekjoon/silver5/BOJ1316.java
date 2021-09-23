package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1316 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        List<Character> alphabets = new ArrayList<>();

        alphabets.add(word.charAt(0));
        char prev = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (prev == word.charAt(i)) {
                continue;
            } else if (prev != word.charAt(i)
                    && alphabets.contains(word.charAt(i))) {
                return false;
            }

            prev = word.charAt(i);
            alphabets.add(word.charAt(i));
        }

        return true;
    }
}