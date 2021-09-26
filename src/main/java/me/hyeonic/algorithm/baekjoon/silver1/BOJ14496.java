package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ14496 {

    public static final int INF = Integer.MAX_VALUE;
    private static final List<List<Node>> graph = new ArrayList<>();
    private static final int[] d = new int[1_001];

    private static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        priorityQueue.offer(new Node(start, 0));
        d[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int now = node.index;
            int distance = node.distance;

            if (d[now] < distance) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    priorityQueue.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt(); // 문자 a
        int b = scanner.nextInt(); // 문자 b

        int n = scanner.nextInt(); // 전체 문자 수 n (노드)
        int m = scanner.nextInt(); // 치환 가능한 문자쌍의 수 m (간선)

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int inputA = scanner.nextInt();
            int inputB = scanner.nextInt();

            graph.get(inputA).add(new Node(inputB, 1));
            graph.get(inputB).add(new Node(inputA, 1));
        }

        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra(a);

        if (d[b] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(d[b]);
        }
    }
}