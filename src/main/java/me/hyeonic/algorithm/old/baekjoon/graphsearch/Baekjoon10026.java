package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10026 {

    static int n;
    static char[][] map, map1, map2;
    static boolean[][] visited;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

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

        char color = map[startX][startY];
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int pollX = location.x;
            int pollY = location.y;

            for (int i = 0; i < 4; i++) {
                int x = pollX + xMove[i];
                int y = pollY + yMove[i];

                if (isLocation(x, y) && map[x][y] == color) {
                    queue.add(new Location(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(bufferedReader.readLine());
        map1 = new char[n][n];
        map2 = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                char color = input.charAt(j);
                map1[i][j] = color;
                if (color == 'G') map2[i][j] = 'R';
                else map2[i][j] = color;
            }
        }

        map = map1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    ++count;
                }
            }
        }

        bufferedWriter.write(count + " ");

        map = map2;
        visited = new boolean[n][n];
        count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    ++count;
                }
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}