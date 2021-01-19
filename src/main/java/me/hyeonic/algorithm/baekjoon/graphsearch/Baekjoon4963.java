package me.hyeonic.algorithm.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon4963 {

    static int[][] map;
    static boolean[][] visited;
    static int w, h;
    static int[] xMove = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] yMove = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Location {
        int x,y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int startX, int startY) {
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

                if (isLocation(x, y)) {
                    queue.add(new Location(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }

    private static boolean isLocation(int x, int y) {
        if (x >= 0 && y >= 0 && x < h && y < w && !visited[x][y] && map[x][y] == 1) return true;
        return false;
    }

    private static void print() {
        System.out.println();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = bufferedReader.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                input = bufferedReader.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            int count = 0; // 섬의 개수
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        ++count;
                    }
                }
            }
            bufferedWriter.write(count + "\n");
//            print();
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 요구사항
  정사각형으로 이루어진 섬과 바다 지도가 주어진다.
  한 정사각현과 가로, 세로, 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.
  1은 땅이고, 0은 바다이다.
  섬의 개수를 세어 출력한다.

 입력
  입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다.
  w와 h는 50보다 작거나 같은 양의 정수이다.
  둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
  입력의 마지막 줄에는 0이 두 개 주어진다.

 출력
 각 테스트 케이스에 대해서, 섬의 개수를 출력한다.
 */