package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1753 {

    public static final int INF = Integer.MAX_VALUE;
    private static final List<List<Node>> graph = new ArrayList<>();
    private static int[] d; // 최단 경로 명시를 위한 테이븖

    private static class Node {
        private final int index;
        private final int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.distance < o2.distance) {
                return -1;
            } else if (o1.distance == o2.distance) {
                return 0;
            }
            return 1;
        });

        d[start] = 0;
        priorityQueue.offer(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int index = node.index;
            int distance = node.distance;

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

        int v = scanner.nextInt(); // 정점의 개수
        int e = scanner.nextInt(); // 간선의 개수
        int k = scanner.nextInt(); // 시작 정점 번호

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt(); // start
            int b = scanner.nextInt(); // end
            int c = scanner.nextInt(); // weight

            graph.get(a).add(new Node(b, c));
        }

        d = new int[v + 1];
        Arrays.fill(d, INF);

        dijkstra(k);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (d[i] == INF) {
                stringBuilder.append("INF\n");
            } else {
                stringBuilder.append(d[i]).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}