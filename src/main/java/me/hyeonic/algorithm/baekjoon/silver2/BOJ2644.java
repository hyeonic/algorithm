package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2644 {

    private static int result = -1;
    private static int start, end;
    private static boolean[] visited;
    private static List<List<Integer>> graph;

    private static void dfs(int x, int count) {
        visited[x] = true;

        for (Integer i : graph.get(x)) {
            if (!visited[i]) {
                if (i == end) {
                    result = count + 1;
                    return;
                }
                dfs(i, count + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        start = scanner.nextInt();
        end = scanner.nextInt();

        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(start, 0);

        System.out.println(result);
    }
}