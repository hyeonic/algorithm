package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ13565 {

    private static int n, m;
    private static int[][] store;
    private static int[][] graph;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean bfs(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        graph[x][y] = -1;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 4; i++) {
                x = location.x + dx[i];
                y = location.y + dy[i];
                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    graph[x][y] = -1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (graph[n - 1][i] == -1) {
                return true;
            }
        }

        return false;
    }

    private static boolean isLocation(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || graph[x][y] == 1 || graph[x][y] == -1) {
            return false;
        }

        return true;
    }

    private static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = store[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        store = new int[n][m];
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            for (int j = 0; j < m; j++) {
                int value = next.charAt(j) - '0';
                store[i][j] = value;
            }
        }

        for (int i = 0; i < m; i++) {
            copy();
            if (store[0][i] == 0) {
                if (bfs(0, i)) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }
}