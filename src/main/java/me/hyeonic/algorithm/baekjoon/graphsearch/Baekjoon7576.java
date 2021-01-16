package me.hyeonic.algorithm.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon7576 {

    static int[][] map;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};
    static int n, m;

    static class Location {
        int x, y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {
        Queue<Location> queue = new LinkedList<>();
        int day = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1)
                    queue.add(new Location(i, j));
            }
        }

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int pollX = location.x;
            int pollY = location.y;

            for (int i = 0; i < 4; i++) {
                int x = pollX + xMove[i];
                int y = pollY + yMove[i];

                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    map[x][y] = map[pollX][pollY] + 1;
                }
            }
            print();
        }
    }

    public static boolean isLocation(int x, int y) {
        if(x < 0 || x > m - 1 || y < 0 || y > n - 1) return false;
        if(map[x][y] != 0) return false;
        return true;
    }

    public static void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getMax() {
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        return max - 1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        print();

        bfs();
        bufferedWriter.write(String.valueOf(getMax()));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}