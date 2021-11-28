package me.hyeonic.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P43162 {

    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i, computers);
            }
        }

        return answer;
    }

    public void bfs(int node, int[][] computers) {
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
        P43162 p43162 = new P43162();
        System.out.println(p43162.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(p43162.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
