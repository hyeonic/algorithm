package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ10809 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            }
        }

        for (char c : alphabets.toCharArray()) {
            if (map.containsKey(c)) {
                System.out.print(map.get(c) + " ");
            } else {
                System.out.print("-1 ");
            }
        }
    }
}