package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1916 {

    private static int n, m, start, end;
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
            int curIndex = node.getIndex();
            int curDistance = node.getDistance();

            if (d[curIndex] < curDistance) {
                continue;
            }

            for (int i = 0; i < graph.get(curIndex).size(); i++) {
                int cost = d[curIndex] + graph.get(curIndex).get(i).getDistance();
                if (cost < d[graph.get(curIndex).get(i).getIndex()]) {
                    d[graph.get(curIndex).get(i).getIndex()] = cost;
                    priorityQueue.offer(new Node(graph.get(curIndex).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

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

        start = scanner.nextInt();
        end = scanner.nextInt();

        dijkstra(start);

        System.out.println(d[end]);
    }
}