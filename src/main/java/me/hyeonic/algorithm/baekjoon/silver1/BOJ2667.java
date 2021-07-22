package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2667 {

    private static int n;
    private static int count;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] departments;

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        visited[x][y] = true;
        graph[x][y] = count;

        while (!queue.isEmpty()) {
            Location pollLocation = queue.poll();

            for (int i = 0; i < 4; i++) {
                x = pollLocation.x + dx[i];
                y = pollLocation.y + dy[i];

                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    visited[x][y] = true;
                    graph[x][y] = count;
                }
            }
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
                graph[i][j] = Integer.valueOf(row[j]);
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] != 0) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        int[] apartments = new int[count + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0) {
                    apartments[graph[i][j]]++;
                }
            }
        }

        Arrays.sort(apartments);
        System.out.println(count);
        for (int i = 1; i <= count; i++) {
            System.out.println(apartments[i]);
        }
    }
}