package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ1157 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> map = new HashMap<>();

        String word = scanner.nextLine();
        word = word.toUpperCase();

        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 1) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char c : map.keySet()) {
            max = Math.max(map.get(c), max);
        }

        int count = 0;
        char key = 0;
        for (char c : map.keySet()) {
            if (max == map.get(c)) {
                key = c;
                ++count;
            }
        }

        if (count > 1) {
            System.out.println("?");
        } else {
            System.out.println(key);
        }
    }
}