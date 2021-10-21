package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ13549 {

    private static int n, k;
    private static boolean[] visited = new boolean[100_001];

    private static class Node {
        private int x;
        private int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    private static int bfs() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.time < o2.time) {
                return -1;
            } else if (o1.time == o2.time) {
                return 0;
            }
            return 1;
        });

        priorityQueue.add(new Node(n, 0));
        visited[n] = true;

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            visited[current.x] = true;

            if (current.x == k) {
                return current.time;
            }

            int next;
            next = current.x * 2;
            if (next <= 100_000 && !visited[next]) {
                priorityQueue.add(new Node(next, current.time));
            }

            next = current.x + 1;
            if (next <= 100_000 && !visited[next]) {
                priorityQueue.add(new Node(next, current.time + 1));
            }

            next = current.x - 1;
            if (next >= 0 && !visited[next]) {
                priorityQueue.add(new Node(next, current.time + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 수빈이의 현재점
        k = scanner.nextInt(); // 동생의 현재점

        System.out.println(bfs());
    }
}