package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ18352 {

    private static final int INF = Integer.MAX_VALUE;
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] d = new int[300_001];

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

            Node currentNode = priorityQueue.poll();
            int index = currentNode.index;
            int distance = currentNode.distance;

            if (d[index] < distance) {
                continue;
            }

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = d[index] + graph.get(index).get(i).distance;
                if (cost < d[graph.get(index).get(i).index]) {
                    d[graph.get(index).get(i).index] = cost;
                    priorityQueue.offer(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 도시(노드)의 개수
        int m = scanner.nextInt(); // 도로(간선)의 개수
        int k = scanner.nextInt(); // 거리 정보
        int x = scanner.nextInt(); // 출발 도시의 번호

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph.get(a).add(new Node(b, 1));
        }

        Arrays.fill(d, INF);

        dijkstra(x);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                stringBuilder.append(i).append("\n");
            }
        }

        if (stringBuilder.toString().isBlank()) {
            System.out.println("-1");
            return;
        }

        System.out.println(stringBuilder);
    }
}