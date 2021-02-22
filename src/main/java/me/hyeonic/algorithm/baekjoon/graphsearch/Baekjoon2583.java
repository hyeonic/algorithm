package me.hyeonic.algorithm.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon2583 {

    static int[][] map;
    static boolean[][] visited;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};
    static int m, n;

    static class Location {
        int x, y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int bfs(int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startX, startY));
        visited[startX][startY] = true;
        int count = 1;

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
                    ++count;
                }
            }
        }
        return count;
    }

    private static int dfs(int startX, int startY, int count) {
        visited[startX][startY] = true;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int x = startX + xMove[i];
                int y = startY + yMove[i];

                if (isLocation(x, y)) {
                    count = Math.max(count, dfs(x, y, ++count));
                }
            }
        }

        return count;
    }

    private static boolean isLocation(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 0 && !visited[x][y]) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            String[] inputLocation = bufferedReader.readLine().split(" ");
            int x1 = Integer.parseInt(inputLocation[0]);
            int y1 = Integer.parseInt(inputLocation[1]);

            int x2 = Integer.parseInt(inputLocation[2]);
            int y2 = Integer.parseInt(inputLocation[3]);

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visited[i][j])
//                    resultList.add(bfs(i, j));
                    resultList.add(dfs(i, j, 1));
            }
        }

        Collections.sort(resultList);

        bufferedWriter.write(resultList.size() + "\n");
        for (Integer result : resultList)
            bufferedWriter.write(result + " ");

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}