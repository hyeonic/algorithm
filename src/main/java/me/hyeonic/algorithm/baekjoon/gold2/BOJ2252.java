package me.hyeonic.algorithm.baekjoon.gold2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2252 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            graph.get(start).add(end);
            indegree[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // 진입 차수가 0인 노드 queue에 넣기
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            result.add(node);

            for (Integer target : graph.get(node)) {
                indegree[target]--;

                if (indegree[target] == 0) {
                    queue.add(target);
                }
            }
        }

        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}