package me.hyeonic.algorithm.thisiscodingtest.chapter09;

import java.util.Arrays;
import java.util.Scanner;

public class Practice9_4 {

    private static final int INF = (int) 1e9;
    private static int n, m, k, x;
    private static int[][] graph = new int[101][101];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i <= 100; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= m; b++) {
                if (a == b) {
                    graph[a][b] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = scanner.nextInt();
        k = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if (distance >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(distance);
        }
    }
}

/*
입력
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

출력
3

입력
4 2
1 3
2 4
3 4

출력
-1
 */