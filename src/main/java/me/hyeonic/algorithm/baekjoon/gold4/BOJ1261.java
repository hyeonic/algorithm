package me.hyeonic.algorithm.baekjoon.gold4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1261 {

    private static int n, m;
    private static int[][] graph;
    private static boolean[][] visited;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static class Location {
        private int x;
        private int y;
        private int count;

        public Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static int bfs(int x, int y) {
        PriorityQueue<Location> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.count < o2.count) {
                return -1;
            } else if (o1.count == o2.count) {
                return 0;
            }
            return 1;
        });

        priorityQueue.add(new Location(x, y, 0));
        visited[x][y] = true;

        while (!priorityQueue.isEmpty()) {
            Location location = priorityQueue.poll();

            if (location.x == n && location.y == m) {
                return location.count;
            }

            for (int i = 0; i < 4; i++) {
                x = location.x + dx[i];
                y = location.y + dy[i];
                if (isLocation(x, y)) {
                    if (graph[x][y] == 0) {
                        visited[x][y] = true;
                        priorityQueue.add(new Location(x, y, location.count));
                    } else if (graph[x][y] == 1) {
                        visited[x][y] = true;
                        priorityQueue.add(new Location(x, y, location.count + 1));
                    }
                }
            }
        }

        return 0;
    }

    private static boolean isLocation(int x, int y) {
        if (x <= 0 || x > n || y <= 0 || y > m || visited[x][y]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt();
        n = scanner.nextInt();

        graph = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String next = scanner.next();
            for (int j = 1; j <= m; j++) {
                int value = next.charAt(j - 1) - '0';
                graph[i][j] = value;
            }
        }

        System.out.println(bfs(1, 1));
    }
}