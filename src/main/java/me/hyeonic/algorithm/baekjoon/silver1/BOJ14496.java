package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ14496 {

    private static int a, b, n, m;
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] d = new int[1_001];

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
            if (o1.getDistance() < o2.getDistance()) {
                return -1;
            }
            return 1;
        });

        priorityQueue.offer(new Node(start, 0));
        d[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int now = node.getIndex();
            int distance = node.getDistance();

            if (d[now] < distance) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    priorityQueue.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt(); // 문자 a
        b = scanner.nextInt(); // 문자 b

        n = scanner.nextInt(); // 전체 문자 수 n (노드)
        m = scanner.nextInt(); // 치환 가능한 문자쌍의 수 m (간선)

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph.get(a).add(new Node(b, 1));
            graph.get(b).add(new Node(a, 1));
        }

        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra(a);

        if (d[b] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(d[b]);
        }
    }
}