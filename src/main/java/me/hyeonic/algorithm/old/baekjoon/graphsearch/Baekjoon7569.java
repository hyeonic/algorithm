package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon7569 {

    static int[][][] map;
    static int[] xMove = {-1, 1, 0, 0, 0, 0};
    static int[] yMove = {0, 0, -1, 1, 0, 0};
    static int[] zMove = {0, 0, 0, 0, 1, -1};
    static int m, n, h;

    static class Location {
        int x, y, z;
        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static void bfs() {
        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < h; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < m; k++)
                    if (map[i][j][k] == 1) queue.add(new Location(j, k, i));

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int pollX = location.x;
            int pollY = location.y;
            int pollZ = location.z;

            for (int i = 0; i < 6; i++) {
                int x = pollX + xMove[i];
                int y = pollY + yMove[i];
                int z = pollZ + zMove[i];

                if (isLocation(x, y, z)) {
                    queue.add(new Location(x, y, z));
                    map[z][x][y] = map[pollZ][pollX][pollY] + 1;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y, int z) {
        if (x >= 0 && y >= 0 && z >= 0 && x < n && y < m && z < h && map[z][x][y] == 0) return true;
        return false;
    }

    private static int getMax() {
        int max = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) return -1;

                    max = Math.max(max, map[i][j][k]);
                }
            }
        }
        return max - 1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        m = Integer.parseInt(input[0]); // y
        n = Integer.parseInt(input[1]); // x
        h = Integer.parseInt(input[2]); // z
        map = new int[h][n][m]; // z, x, y

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] s = bufferedReader.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(s[k]);
                }
            }
        }

        bfs();
        bufferedWriter.write(String.valueOf(getMax()));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}