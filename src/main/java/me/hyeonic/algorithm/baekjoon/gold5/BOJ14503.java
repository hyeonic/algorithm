package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.Scanner;

public class BOJ14503 {
    private static int n;
    private static int m;
    private static int count;
    private static int[][] graph;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int direction = scanner.nextInt();
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        operate(row, col, direction);

        System.out.println(count);
    }

    private static void operate(int row, int col, int direction) {
        // 1. 현 위치 청소
        clean(row, col);

        // 2. 왼쪽 방향부터 차례대로 탐색 진행
        for (int i = 0; i < 4; i++) {
            direction = rotate(direction);
            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];

            if (isLocation(nextRow, nextCol) && graph[nextRow][nextCol] == 0) {
                operate(nextRow, nextCol, direction);
                return;
            }
        }

        // 3. 네 방향 모두 청소가 되어 있거나 벽인 경우
        reverse(row, col, direction);
    }

    private static void clean(int row, int col) {
        if (graph[row][col] != 2) {
            graph[row][col] = 2;
            count++;
        }
    }

    private static int rotate(int direction) {
        direction--;
        if (direction == -1) {
            direction = 3;
        }
        return direction;
    }

    private static void reverse(int row, int col, int direction) {
        int backDirection = (direction + 2) % 4;
        int backRow = row + dr[backDirection];
        int backCol = col + dc[backDirection];
        if (isLocation(backRow, backCol) && graph[backRow][backCol] != 1) {
            operate(backRow, backCol, direction);
        }
    }

    private static boolean isLocation(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
