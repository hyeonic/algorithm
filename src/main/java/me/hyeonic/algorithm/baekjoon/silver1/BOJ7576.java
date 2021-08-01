package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7576 {

    static int m, n;
    static int[][] graph;

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    static class Location {
        int x; int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs() {
        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new Location(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Location poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    graph[x][y] = graph[poll.x][poll.y] + 1;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || graph[x][y] != 0) {
            return false;
        }
        return true;
    }

    private static int getMax() {
        int max = Integer.MIN_VALUE;
        for (int[] ints : graph) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return -1;
                }

                max = Math.max(anInt, max);
            }
        }

        return max - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt(); // 가로
        n = scanner.nextInt(); // 세로

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        bfs();

        System.out.println(getMax());
    }
}