package me.hyeonic.algorithm.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon14502 {

    static int n, m;
    static int[][] map;
    static int[][] virusMap;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};
    static int max;

    static class Location {
        int x, y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // dfs + 백트래킹으로 3개의 벽 세우기
    public static void dfs(int count) {
        if (count == 3) { // 벽 3개를 세웠을 때
            bfs();        // bfs로 바이러스를 채운다.
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1; // 벽 세우기
                    dfs(count + 1);
                    map[i][j] = 0; // 벽 허물기
                }
            }
        }
    }

    private static void bfs() {
        virusMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virusMap[i][j] = map[i][j];
            }
        }

        Queue<Location> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) { // queue에 바이러스를 담는다.
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == 2) {
                    queue.add(new Location(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int pollX = location.x;
            int pollY = location.y;

            for (int i = 0; i < 4; i++) { // 4방향 탐색
                int x = pollX + xMove[i];
                int y = pollY + yMove[i];
                if (isLocation(x, y)) { // 벽이 아닌 곳이면 바이러스를 퍼트린다.
                    virusMap[x][y] = 2;
                    queue.add(new Location(x, y));
                }
            }
        }
        max = Math.max(max, countSafeArea()); // 안전구역의 값을 갱신한다.
    }

    private static boolean isLocation(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m && virusMap[x][y] == 0) return true;
        return false;
    }

    // 안전 구역의 개수를 count한다.
    private static int countSafeArea() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == 0) {
                    ++count;
                }
            }
        }
        return count;
    }

    private static void print(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
//        print(map);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(1);
                    map[i][j] = 0;
                }
            }
        }

        bufferedWriter.write(String.valueOf(max));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 요구사항
  바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
  연구소는 크기가 N x M인 직사각형으로 나타낼 수 있다.
  연구소는 빈 칸, 벽으로 이루어져 있다. 벽은 칸 하나를 차지한다.
  일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우 인접한 빈 칸으로 모두 퍼져나갈 수 있다.
  새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

  0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다.

 https://zzang9ha.tistory.com/232
 */

