package me.hyeonic.algorithm.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon1182 {

    static int n;
    static int s;
    static int count;
    static int[] sequece;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();
        sequece = new int[n];
        for (int i = 0; i < n; i++) {
            sequece[i] = scanner.nextInt();
        }

        dfs(0, 0);

        if (s == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }

        scanner.close();
    }

    private static void dfs(int idx, int prev) {
        if (idx == n) {
            if (prev == s) {
                count++;
            }
            return;
        }

        dfs(idx + 1, prev + sequece[idx]);
        dfs(idx + 1, prev);
    }
}