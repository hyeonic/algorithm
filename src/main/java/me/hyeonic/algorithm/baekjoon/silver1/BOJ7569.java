package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7569 {

    private static int m, n, h;
    private static int[][][] graph;

    // 상 하 좌 우 위 아래
    private static int[] dx = {-1, 1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, -1, 1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, -1, 1};

    private static class Location {
        int x, y, z;

        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static void bfs() {
        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (graph[i][j][k] == 1) {
                        queue.add(new Location(j, k, i));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 6; i++) {
                int x = location.x + dx[i];
                int y = location.y + dy[i];
                int z = location.z + dz[i];

                if (isLocation(x, y, z)) {
                    queue.add(new Location(x, y, z));
                    graph[z][x][y] = graph[location.z][location.x][location.y] + 1;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y, int z) {
        if (x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= h || graph[z][x][y] != 0) {
            return false;
        }
        return true;
    }

    private static int getMax() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (graph[i][j][k] == 0) {
                        return -1;
                    }

                    max = Math.max(max, graph[i][j][k]);
                }
            }
        }

        return max - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt(); // 가로
        n = scanner.nextInt(); // 세로
        h = scanner.nextInt(); // 높이

        graph = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    graph[i][j][k] = scanner.nextInt();
                }
            }
        }

        bfs();

        System.out.println(getMax());
    }
}