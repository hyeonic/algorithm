package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10026 {

    private static int n;
    private static String[][] graph;
    private static boolean[][] visited;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static class Location {
        private final int x;
        private final int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y, String color) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 4; i++) {
                x = location.x + dx[i];
                y = location.y + dy[i];
                if (isLocation(x, y, color)) {
                    queue.add(new Location(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y, String color) {
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || !graph[x][y].equals(color)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        graph = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] colors = scanner.next().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = colors[j];
            }
        }

        int noneBlindness = 0; // 적록색약이 아닌 사람
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j].equals("R") && !visited[i][j]) {
                    bfs(i, j, "R");
                    noneBlindness++;
                } else if (graph[i][j].equals("G") && !visited[i][j]) {
                    bfs(i, j, "G");
                    noneBlindness++;
                } else if (graph[i][j].equals("B") && !visited[i][j]) {
                    bfs(i, j, "B");
                    noneBlindness++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j].equals("G")) {
                    graph[i][j] = "R";
                }
            }
        }
        visited = new boolean[n][n];

        int blindness = 0; // 적록색약인 사람
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j].equals("R") && !visited[i][j]) {
                    bfs(i, j, "R");
                    blindness++;
                } else if (graph[i][j].equals("B") && !visited[i][j]) {
                    bfs(i, j, "B");
                    blindness++;
                }
            }
        }

        System.out.println(noneBlindness + " " + blindness);
    }
}