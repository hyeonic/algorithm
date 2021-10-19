package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7562 {

    private static int l;
    private static int[][] graph;
    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    private static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 8; i++) {
                x = location.x + dx[i];
                y = location.y + dy[i];

                if (isLocation(x, y)) {
                    if (graph[x][y] == -1) {
                        graph[x][y] = graph[location.x][location.y] + 1;
                        return;
                    }

                    queue.add(new Location(x, y));
                    graph[x][y] = graph[location.x][location.y] + 1;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x >= 0 && x < l && y >= 0 && y < l && (graph[x][y] == 0 || graph[x][y] == -1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            l = scanner.nextInt();
            graph = new int[l][l];

            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            int endX = scanner.nextInt();
            int endY = scanner.nextInt();

            // 시작점과 끝점이 같은 경우
            if (startX == endX && startY == endY) {
                System.out.println(0);
                continue;
            }

            graph[endX][endY] = -1; // 끝점

            bfs(startX, startY);

            System.out.println(graph[endX][endY]);
        }
    }
}