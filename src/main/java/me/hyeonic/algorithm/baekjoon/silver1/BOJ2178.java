package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {

    public static int[][] map;
    public static int n;
    public static int m;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

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
                    map[x][y] += map[location.x][location.y];
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x <= 0 || x > n || y <= 0 || y > m || map[x][y] == 0 || map[x][y] > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String row = scanner.nextLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);

        System.out.println(map[n][m]);
    }
}