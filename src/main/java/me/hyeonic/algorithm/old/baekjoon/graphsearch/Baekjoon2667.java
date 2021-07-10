package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2667 {

    static int[][] matrix;
    static boolean[][] visited;
    static int n;
    static int count;
    static int[] apartments;

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
        visited[startX][startY] = true;
        ++apartments[count];

        //             상, 하, 좌, 우
        int[] xMove = {-1, 1, 0, 0};
        int[] yMove = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int row = location.x;
            int col = location.y;

            for (int i = 0; i < 4; i++) { // 상하좌우 4방향 탐색
                int x = row + xMove[i];
                int y = col + yMove[i];

                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    visited[x][y] = true;
                    ++apartments[count];
                }
            }
        }
    }

    public static boolean isLocation(int x, int y){
        if(x < 1 || x > n || y < 1 || y > n) return false;
        if(visited[x][y] != false || matrix[x][y] == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(bufferedReader.readLine());
        count = 0;
        apartments = new int[(n + 1) * (n + 1)];
        matrix = new int[(n + 1)][(n + 1)];
        visited = new boolean[(n + 1)][(n + 1)];

        for(int i = 1; i <= n; i++){
            String row = bufferedReader.readLine();
            for(int j = 1; j <= n; j++) {
                matrix[i][j] = row.charAt(j - 1) - '0';
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    ++count;
                    bfs(i,j);
                }
            }
        }

        Arrays.sort(apartments);

        bufferedWriter.write(count + "\n");
        for (int i = 0; i < apartments.length; i++) {
            if(apartments[i] != 0) bufferedWriter.write(apartments[i] + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}