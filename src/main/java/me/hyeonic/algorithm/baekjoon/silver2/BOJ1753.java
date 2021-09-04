package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1753 {

    private static int n, m, start;
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] d = new int[20_001];

    private static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getDistance() < o2.distance) {
                return -1;
            }
            return 1;
        });

        priorityQueue.offer(new Node(start, 0));
        d[start] = 0;

        while (!priorityQueue.isEmpty()) {

            Node currentNode = priorityQueue.poll();
            int currentIndex = currentNode.getIndex();
            int currentDistance = currentNode.getDistance();

            if (d[currentIndex] < currentDistance) {
                continue;
            }

            for (int i = 0; i < graph.get(currentIndex).size(); i++) {
                int cost = d[currentIndex] + graph.get(currentIndex).get(i).getDistance();
                if (cost < d[graph.get(currentIndex).get(i).getIndex()]) {
                    d[graph.get(currentIndex).get(i).getIndex()] = cost;
                    priorityQueue.offer(new Node(graph.get(currentIndex).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        start = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra(start);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (d[i] == Integer.MAX_VALUE) {
                stringBuilder.append("INF\n");
            } else {
                stringBuilder.append(d[i]).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}