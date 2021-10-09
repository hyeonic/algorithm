package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2606 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    private static int bfs(int node) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();
            List<Integer> nodes = graph.get(node);
            for (Integer value : nodes) {
                if (!visited[value]) {
                    visited[value] = true;
                    count++;
                    queue.add(value);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodeCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();

        visited = new boolean[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(bfs(1));
    }
}