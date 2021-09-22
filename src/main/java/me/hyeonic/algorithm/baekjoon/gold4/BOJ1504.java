package me.hyeonic.algorithm.baekjoon.gold4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1504 {

    public static final int INF = Integer.MAX_VALUE;
    private static int n, e;
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] d;

    private static class Node {
        private final int index;
        private final int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    private static int dijkstra(int start, int end) {

        d = new int[n + 1];
        Arrays.fill(d, INF);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.distance < o2.distance) {
                return -1;
            } else if (o1.distance == o2.distance) {
                return 0;
            }
            return 1;
        });

        d[start] = 0;
        priorityQueue.add(new Node(start, 0));

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

        if (d[end] == INF) {
            return -1;
        } else {
            return d[end];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 정점의 개수
        e = scanner.nextInt(); // 간선의 개수

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt(); // start
            int b = scanner.nextInt(); // end
            int c = scanner.nextInt(); // weight

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int v1 = scanner.nextInt(); // 필수 정점
        int v2 = scanner.nextInt(); // 필수 정점

        long answer1 = 0;
        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, n);

        long answer2 = 0;
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, n);

        if (Math.min(answer1, answer2) < 0) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(answer1, answer2));
        }

        int a = INF;
        System.out.println(a + 1);
    }
}

/*
answer1 += dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
System.out.println("answer1 -> " + answer1);
answer2 += dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
System.out.println("answer2 -> " + answer2);

answer1 -> 2147483647
answer2 -> 2147483645
2147483645
 */

/*
answer1 += dijkstra(1, v1);
System.out.println("1 -> " + answer1);
answer1 += dijkstra(v1, v2);
System.out.println("2 -> " + answer1);
answer1 += dijkstra(v2, n);
System.out.println("3 -> " + answer1);

answer2 += dijkstra(1, v2);
System.out.println("1 -> " + answer2);
answer2 += dijkstra(v2, v1);
System.out.println("2 -> " + answer2);
answer2 += dijkstra(v1, n);
System.out.println("3 -> " + answer2);

1 -> 0
2 -> 2147483647
3 -> 2147483647

1 -> 2147483647
2 -> 4294967294
3 -> 6442450941
-1

if (Math.min(answer1, answer2) >= Integer.MAX_VALUE) {
    System.out.println(-1);
} else {
    System.out.println(Math.min(answer1, answer2));
}
*/