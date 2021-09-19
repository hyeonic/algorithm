package me.hyeonic.algorithm.baekjoon.gold4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ1647 {

    private static int v, e;
    private static int[] parent = new int[100_001];
    private static List<Edge> edges = new ArrayList<>();

    private static class Edge {
        private int nodeA;
        private int nodeB;
        private int distance;

        public Edge(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        v = scanner.nextInt();
        e = scanner.nextInt();

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int cost = scanner.nextInt();

            edges.add(new Edge(a, b, cost));
        }

        // 간선의 비용 오름차순 정렬
//        Collections.sort(edges, (o1, o2) -> {
//            return o1.distance - o2.distance;
//        });

        edges.sort(Comparator.comparingInt(o -> o.distance));

        int result = 0;
        int last = 0;
        for (Edge edge : edges) {
            int a = edge.nodeA;
            int b = edge.nodeB;
            int cost = edge.distance;

            if (find(a) != find(b)) {
                union(a, b);
                result += cost;
                last = cost;
            }
        }

        System.out.println(result - last);
    }
}