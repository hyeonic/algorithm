package me.hyeonic.algorithm.example.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_array {
    static int[][] graph;
    static boolean[] visited;
    static int n, m, v;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < n + 1; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i < n + 1; i++) {
            if (graph[start][i] == 1 && !visited[i]) dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        v = Integer.parseInt(input[2]);

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] vertices = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(vertices[0]);
            int y = Integer.parseInt(vertices[1]);

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);

        bufferedReader.close();
    }
}
