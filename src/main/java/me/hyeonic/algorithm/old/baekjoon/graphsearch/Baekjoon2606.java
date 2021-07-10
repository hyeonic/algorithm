package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2606 {

    static int[][] matrix;
    static boolean[] visited;
    static int v, e;
    static int count = 0;

    public static void bfs(int start) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            ++count;

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[vertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void print() {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        v = Integer.parseInt(bufferedReader.readLine());
        e = Integer.parseInt(bufferedReader.readLine());

        matrix = new int[v + 1][v + 1];
        visited = new boolean[v + 1];

        for (int i = 1; i <= e; i++) {
            String[] vertices = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(vertices[0]);
            int y = Integer.parseInt(vertices[1]);

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        print(); // 값이 잘 들어 갔는지 확인
        bfs(1);
        bufferedWriter.write(String.valueOf(count - 1));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
