package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11403 {

    private static final int INF = (int) 1e9;
    private static int n;
    private static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    graph[i][j] = value;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (graph[a][b] == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }
}