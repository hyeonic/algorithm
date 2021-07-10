package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1012 {

    static int[][] map;
    static boolean[][] visited;
    static int n, m, v;

    static class Location {

        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int startX, int startY) {

        int[] xMove = {-1, 1, 0, 0};
        int[] yMove = {0, 0, -1, 1};

        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int x = location.x;
            int y = location.y;

            for (int i = 0; i < 4; i++) {
                int curX = x + xMove[i];
                int curY = y + yMove[i];

                if (isLocation(curX, curY)) {
                    queue.add(new Location(curX, curY));
                    visited[curX][curY] = true;
                }
            }
        }
//        print();
    }

    public static boolean isLocation(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        if (visited[x][y] != false || map[x][y] == 0) return false;
        return true;
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(visited[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine());
        int[] counts = new int[t];

        for (int c = 0; c < t; c++) {
            String[] input = bufferedReader.readLine().split(" ");
            m = Integer.parseInt(input[0]); // 가로
            n = Integer.parseInt(input[1]); // 세로
            v = Integer.parseInt(input[2]);

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < v; i++) {
                String[] vertices = bufferedReader.readLine().split(" ");
                int x = Integer.parseInt(vertices[0]);
                int y = Integer.parseInt(vertices[1]);

                map[y][x] = 1;
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
            counts[c] = count;
//            print();
        }

        for (int count : counts) {
            bufferedWriter.write(count + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}