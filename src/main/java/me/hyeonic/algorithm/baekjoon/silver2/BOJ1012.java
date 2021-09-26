package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1012 {

    private static int[][] map;
    private static boolean[][] visited;
    private static int n, m;
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

    private static void bfs(int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startX, startY));

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = location.x + dx[i];
                int y = location.y + dy[i];
                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 0 || visited[x][y]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // 테스트 케이스의 개수

        while (t-- > 0) {
            m = scanner.nextInt(); // 가로길이
            n = scanner.nextInt(); // 세로길이
            int k = scanner.nextInt(); // 배추가 심어져 있는 위치의 개수

            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                map[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}

class BOJ1012DFS {

    private static int[][] map;
    private static boolean[][] visited;
    private static int n, m;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static void dfs(int x, int y) {

        if (!isLocation(x, y)) {
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }

    private static boolean isLocation(int x, int y) {

        // 공간을 벗어난 경우
        if (x < 0 || x >= n || y < 0 || y >= m ) {
            return false;
        }

        // 배추가 아닌 경우
        if (map[x][y] == 0) {
            return false;
        }

        // 이미 방문한 경우
        if (visited[x][y]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // 테스트 케이스의 개수

        while (t-- > 0) {
            m = scanner.nextInt(); // 가로길이
            n = scanner.nextInt(); // 세로길이
            int k = scanner.nextInt(); // 배추가 심어져 있는 위치의 개수

            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                map[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}