package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502 {

    private static int n, m, cleanArea;
    private static int[][] graph;
    private static int[][] copyGraph;

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bruteForce(int depth) {
        if (depth == 3) {
            copy(); // 벽 세운 것을 copy
            bfs(); // bfs 진행
            // 안전 구역 최신화
            cleanArea = Math.max(cleanArea, getCleanArea());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    bruteForce(depth + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyGraph[i][j] == 2) {
                    queue.offer(new Location(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = location.x + dx[i];
                int y = location.y + dy[i];
                if (isLocation(x, y)) {
                    queue.offer(new Location(x, y));
                    copyGraph[x][y] = 2;
                }
            }
        }
    }

    private static void copy() {
        copyGraph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }
    }

    private static int getCleanArea() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyGraph[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isLocation(int x, int y) {
        // 정상적인 좌표가 아닌 경우
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        // 벽인 경우
        if (copyGraph[x][y] == 1) {
            return false;
        }

        // 이미 감염된 경우
        if (copyGraph[x][y] == 2) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        bruteForce(0);

        System.out.println(cleanArea);
    }
}