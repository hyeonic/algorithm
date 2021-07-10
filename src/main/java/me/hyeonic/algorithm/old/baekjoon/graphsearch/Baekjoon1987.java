package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1987 {

    static int r, c, max;
    static char[][] board;
    static boolean[] visited;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    private static void dfs(int x, int y, int d) {

        visited[board[x][y] - 'A'] = true;
        for (int i = 0; i < 4; i++) {
            int currentX = x + xMove[i];
            int currentY = y + yMove[i];

            if (isLocation(currentX, currentY)) {
                System.out.println("x: " + x + " | y: " + y + " | d: " + d);
                dfs(currentX, currentY, d + 1);
            }
        }
        visited[board[x][y] - 'A'] = false;
        max = Math.max(max, d);
    }

    private static boolean isLocation(int x, int y) {
        if (x > 0 && y > 0 && x <= r && y <= c && !visited[board[x][y] - 'A']) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        // 1 <= r, c <= 20
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        board = new char[r + 1][c + 1];
        visited = new boolean[26]; // 방문한 알파벳

        for (int i = 1; i < board.length; i++) {
            String[] row = bufferedReader.readLine().split("");
            for (int j = 1; j < board[i].length; j++) {
                board[i][j] = row[j - 1].charAt(0);
            }
        }

        dfs(1, 1, 1);
        System.out.println(max);

        bufferedReader.close();
    }
}