package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2178 {

    static int[][] graph;
    static int[][] visited;
    static int n, m;

    static class Location {
        int x, y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startX, startY));

        System.out.println("add (" + startX+ ", " + startY + ")");
        System.out.print("[");
        for (Location value : queue) {
            System.out.print("(" + value.x + ", " + value.x + ")");
        }
        System.out.print("]");
        System.out.println();

        /**                     상 x - 1, y
         *  좌 x, y - 1             x, y             우 x, y + 1
         *                      하 x + 1, y
         */
        //             상, 하, 좌, 우
        int[] xMove = {-1, 1, 0, 0};
        int[] yMove = {0, 0, -1, 1};

        visited[startX][startY] = 1;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int row = location.x;
            int col = location.y;
            System.out.println("poll (" + row + ", " + col + ")");
            System.out.print("[");
            for (Location value : queue) {
                System.out.print("(" + value.x + ", " + value.y + ")");
            }
            System.out.print("]");
            System.out.println();

            for (int i = 0; i < 4; i++) { // 상하좌우 4방향 탐색
                int x = row + xMove[i];
                int y = col + yMove[i];

                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    System.out.println("add (" + x + ", " + y + ")");
                    System.out.print("[");
                    for (Location value : queue) {
                        System.out.print("(" + value.x + ", " + value.y + ") - ");
                    }
                    System.out.print("]");
                    System.out.println();
                    visited[x][y] = visited[row][col] + 1;
                }
            }
        }
    }

    public static boolean isLocation(int x, int y){
        if(x < 1 || x > n || y < 1 || y > m) return false;
        if(visited[x][y] != 0 || graph[x][y] == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        graph = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            String row = bufferedReader.readLine();
            for(int j = 1; j <= m; j++) {
                graph[i][j] = row.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);

        bufferedWriter.write(String.valueOf(visited[n][m]));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}