package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2468 {

    private static int n;
    private static int[][] graph;
    private static int[][] copyGraph;

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

    private static void bfs(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        copyGraph[x][y] = -1;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 4; i++) {
                x = location.x + dx[i];
                y = location.y + dy[i];
                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    copyGraph[x][y] = -1;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || copyGraph[x][y] == 0 || copyGraph[x][y] == -1) {
            return false;
        }

        return true;
    }

    // 원본 배열을 기준으로 물에 잠긴 지역과 잠기지 않은 지역을 구분한다.
    private static void change(int standard) {
        copyGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (standard >= graph[i][j]) {
                    copyGraph[i][j] = 0; // 물에 잠긴 지역
                } else {
                    copyGraph[i][j] = 1; // 물에 잠기지 않은 안전한 지역
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // 안전 구역의 개수를 저장하기 위한 list
        List<Integer> safeAreas = new ArrayList<>();

        for (int l = 0; l <= 100; l++) {
            change(l);

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 안전 지역이거나 이미 탐색하지 않은 지역인 경우
                    if (copyGraph[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            safeAreas.add(count);
        }

        int max = 0;
        for (Integer safeArea : safeAreas) {
            max = Math.max(max, safeArea);
        }

        System.out.println(max);
    }
}