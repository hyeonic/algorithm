package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ18352 {

    private static int n, m, k, x;

    private static List<List<Node>> graph = new ArrayList<>();

    private static int[] d = new int[300_001];

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

        n = scanner.nextInt(); // 도시(노드)의 개수
        m = scanner.nextInt(); // 도로(간선)의 개수
        k = scanner.nextInt(); // 거리 정보
        x = scanner.nextInt(); // 출발 도시의 번호

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, 1));
        }

        Arrays.fill(d, Integer.MAX_VALUE);

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