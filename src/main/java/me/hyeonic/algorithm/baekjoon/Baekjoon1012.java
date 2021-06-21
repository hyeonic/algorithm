package me.hyeonic.algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1012 {

    public static int n, m, k;
    public static int[][] map; // 전체 맵 정보
    public static boolean[][] visited; //방문한 위치를 저장하기 위한 맵
    public static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서 방향
    public static int[] dy = {0, 1, 0, -1}; // 북 동 남 서 방향

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

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = location.x + dx[i];
                int nextY = location.y + dy[i];
                if (isLocation(nextX, nextY)) {
                    queue.add(new Location(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 1 && !visited[x][y]) {
            return true;
        } else {
            return false;
        }
     }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- != 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                map[x][y] = 1;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        ++count;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }
}