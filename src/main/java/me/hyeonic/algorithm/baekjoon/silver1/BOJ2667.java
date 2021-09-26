package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2667 {

    private static int n;
    private static int[][] graph;
    private static boolean[][] visited;

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int bfs(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            Location location = queue.poll();

            for (int i = 0; i < 4; i++) {
                x = location.x + dx[i];
                y = location.y + dy[i];

                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    visited[x][y] = true;
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isLocation(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || graph[x][y] == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        scanner.nextLine();
        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(row[j]);
            }
        }

        List<Integer> departments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] != 0) {
                    departments.add(bfs(i, j));
                }
            }
        }

        System.out.println(departments.size());
        departments.stream()
                .sorted()
                .forEach(System.out::println);
    }
}

class BOJ2667DFS {

    private static int n, count;
    private static int[][] graph;
    private static boolean[][] visited;

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static void dfs(int x, int y) {

        if (!isLocation(x, y)) {
            return;
        }

        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || graph[x][y] == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        scanner.nextLine();
        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(row[j]);
            }
        }

        List<Integer> departments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] != 0) {
                    dfs(i, j);
                    departments.add(count);
                    count = 0;
                }
            }
        }

        System.out.println(departments.size());
        departments.stream()
                .sorted()
                .forEach(System.out::println);
    }
}