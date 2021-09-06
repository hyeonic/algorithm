package me.hyeonic.algorithm.thisiscodingtest.chapter09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Practice9_5 {

    private static int n, m, start;
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] d = new int[30_001];

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
            int distance = node.getDistance();
            int now = node.getIndex();

            if (d[now] < distance) continue;

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

        int count = 0;
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] != Integer.MAX_VALUE) {
                count++;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        System.out.println((count - 1) + " " + maxDistance);
    }
}

/*
입력
3 2 1
1 2 3
1 3 2

출력
2 4
 */