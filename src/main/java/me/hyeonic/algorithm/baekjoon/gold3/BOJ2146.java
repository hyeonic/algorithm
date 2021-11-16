package me.hyeonic.algorithm.baekjoon.gold3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2146 {

    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static int[][] graph;
    private static int[][] distances;
    private static boolean[][] visited;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 섬 주위를 탐색하며 다른 섬에 닿을 때 까지 너비 우선 탐색 진행
    private static void bfs(int x, int y) {
        visited = new boolean[n][n]; // 다리 길이 중간 저장을 위해 방문 기록 초기화
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        visited[x][y] = true;
        int number = graph[x][y]; // 다른 섬인지 판별하기 위한 섬 번호

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 4; i++) {
                x = location.x + dx[i];
                y = location.y + dy[i];
                if (isLocation(x, y)) {
                    if (graph[x][y] != 0 && graph[x][y] != number) { // 다른 섬이면 다리 길이 최솟값 갱신
                        min = Math.min(min, distances[location.x][location.y]);
                    } else if (graph[x][y] == 0) { // 바다이면 다리 길이 추가 및 방문처리
                        queue.add(new Location(x, y));
                        distances[x][y] = distances[location.x][location.y] + 1;
                        visited[x][y] = true;
                    }
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y]) {
            return false;
        }

        return true;
    }

    // 섬에 번호 지정
    private static void numberingIsland() {
        boolean[][] visited = new boolean[n][n]; // 번호 지정을 위한 방문 처리 배열
        int count = 1;

        // 방문하지 않는 섬을 탐색하며 numbering
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    Queue<Location> queue = new LinkedList<>();
                    queue.add(new Location(i, j));
                    graph[i][j] = count;
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Location location = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int x = location.x + dx[d];
                            int y = location.y + dy[d];
                            if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && graph[x][y] == 1) {
                                queue.add(new Location(x, y));
                                graph[x][y] = count;
                                visited[x][y] = true;
                            }
                        }
                    }

                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        graph = new int[n][n];
        distances = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
                if (graph[i][j] == 1) { // 다리 길이 누적을 위한 distances. 섬이 위치한 곳은 1로 표기
                    distances[i][j] = 1;
                }
            }
        }

        numberingIsland(); // 섬에 번호 지정

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0) { // 섬인 곳 방문
                    bfs(i, j);
                }
            }
        }

        // 최초 섬인 곳을 1로 표기 했기 때문에 -1
        System.out.println(min - 1);
    }
}