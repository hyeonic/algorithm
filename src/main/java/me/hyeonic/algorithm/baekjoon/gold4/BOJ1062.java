package me.hyeonic.algorithm.baekjoon.gold4;

import java.util.Scanner;

public class BOJ1062 {

    private static int n, k;
    private static int max = Integer.MIN_VALUE;
    private static boolean[] visited;
    private static String[] words;

    private static void backtracking(int depth, int alphabet) {

        if (depth == k - 5) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (char c : words[i].toCharArray()) {
                    if (!visited[c - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;
                }
            }

            max = Math.max(max, count);
            return;
        }

        for (int i = alphabet; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        k = scanner.nextInt();

        words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            words[i] = word.replaceAll("anta|tica", "");
        }

        if (k < 5) {
            System.out.println("0");
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        backtracking(0, 0);
        System.out.println(max);
    }
}