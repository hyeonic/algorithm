package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon7562 {

    static int[][] board;
    static boolean[][] visited;
    static int l, startX, startY, endX, endY;
    static int[] xMove = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Location {
        int x, y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int bfs(int startX, int startY) {

        if (startX == endX && startY == endY) return 0;

        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int pollX = location.x;
            int pollY = location.y;

            for (int i = 0; i < 8; i++) {
                int x = pollX + xMove[i];
                int y = pollY + yMove[i];

                if (x == endX && y == endY)
                    return board[pollX][pollY] + 1;

                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    visited[x][y] = true;
                    board[x][y] = board[pollX][pollY] + 1;
                }
            }
        }

        return board[endX][endY];
    }

    private static boolean isLocation(int x, int y) {
        if (x >= 0 && y >= 0 && x < l && y < l && !visited[x][y]) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            l = Integer.parseInt(bufferedReader.readLine()); // 체스판 한 변의 길이
            board = new int[l][l];
            visited = new boolean[l][l];

            String[] input = bufferedReader.readLine().split(" ");
            startX = Integer.parseInt(input[0]);
            startY = Integer.parseInt(input[1]);

            input = bufferedReader.readLine().split(" ");
            endX = Integer.parseInt(input[0]);
            endY = Integer.parseInt(input[1]);

            int count = bfs(startX, startY);
            System.out.println(count);
        }

        bufferedReader.close();
    }
}
