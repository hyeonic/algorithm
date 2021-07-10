package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2468 {

    static int n;
    static int[][] map;
    static int[][] rainMap;
    static boolean[][] visited;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};
    static int count;
    static int max;

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int pollX = location.x;
            int pollY = location.y;

            for (int i = 0; i < 4; i++) {
                int x = pollX + xMove[i];
                int y = pollY + yMove[i];

                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n && rainMap[x][y] == 1 && !visited[x][y]) return true;
        return false;
    }

    private static void createRainMap(int height) {
        rainMap = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= height) rainMap[i][j] = 0;
                else rainMap[i][j] = 1;
            }
        }
//        print();
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rainMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(bufferedReader.readLine());

        map = new int[n][n];
        rainMap = new int[n][n];

        int height = 0;
        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                height = Math.max(height, map[i][j]);
            }
        }

        for (int h = 0; h <= height; h++) {
            createRainMap(h);
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (rainMap[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        ++count;
                    }
                }
            }
            max = Math.max(max, count);
        }

        bufferedWriter.write(String.valueOf(max));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 요구사항
  어떤 지역의 높이를 파악한다.
  그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개 만들어 지는 지를 조사한다.
  장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다.


 */
