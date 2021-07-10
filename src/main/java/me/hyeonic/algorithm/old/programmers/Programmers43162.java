package me.hyeonic.algorithm.old.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers43162 {

    static boolean[] visited;

    private static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
//                dfs(i, computers);
                bfs(i, computers);
            }
        }

        return answer;
    }

    private static void dfs(int node, int[][] computers) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                dfs(i, computers);
            }
        }
    }

    private static void bfs(int node, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        
        while (!queue.isEmpty()) {
            Integer pollNode = queue.poll();

            for (int i = 0; i < computers.length; i++) {
                if (!visited[i] && computers[pollNode][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{
                {1, 1, 0}, // 1
                {1, 1, 0}, // 2
                {0, 0, 1}, // 3
        }));

        System.out.println(solution(3, new int[][]{
                {1, 1, 0}, // 1
                {1, 1, 1}, // 2
                {0, 1, 1}, // 3
        }));
    }
}