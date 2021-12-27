package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ5567 {
    private static int n;
    private static boolean[] visited;
    private static List<List<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int m = scanner.nextInt();

        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1, 1);

        System.out.println(getCount());
    }

    private static void dfs(int x, int depth) {
        if (depth == 3) {
            return;
        }

        for (Integer i : graph.get(x)) {
            visited[i] = true;
            dfs(i, depth + 1);
        }
    }

    private static int getCount() {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i]) {
                count++;
            }
        }
        return count;
    }
}
