package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ11725 {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] parent;

    private static void dfs(int x) {
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (parent[y] == 0) {
                parent[y] = x;
                dfs(y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 노드의 개수

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // 양방향 그래프
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        parent[1] = 1;
        dfs(1);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            stringBuilder.append(parent[i]).append("\n");
        }

        System.out.println(stringBuilder);
    }
}