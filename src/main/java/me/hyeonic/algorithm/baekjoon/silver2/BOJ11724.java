package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BOJ11724 {

    private static int n, m;
    private static int[] parent = new int[1_001];

    private static int find(int x) {

        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u < v) {
            parent[v] = u;
        } else {
            parent[u] = v;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 노드의 개수 n
        m = scanner.nextInt(); // 간선의 개수 m

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            union(u, v);
        }

//        Map<Integer, Integer> result = new HashMap<>();
//        for (int i = 1; i <= n; i++) {
//            result.put(find(parent[i]), result.getOrDefault(find(parent[i]), 0) + 1);
//        }

        Set<Integer> result = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            result.add(find(parent[i]));
        }

        System.out.println(result.size());
    }
}