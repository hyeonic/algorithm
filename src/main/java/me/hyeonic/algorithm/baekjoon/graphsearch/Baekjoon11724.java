package me.hyeonic.algorithm.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon11724 {

    static int[][] matrix;
    static int n, m;
    static boolean[] visited;
    static int count;

    public static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            Integer pollVertex = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (matrix[pollVertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]); // 정점 vertex 의 개수
        m = Integer.parseInt(input[1]); // 간선 edge 의 개수

        matrix = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] vertices = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(vertices[0]);
            int y = Integer.parseInt(vertices[1]);

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

//        print();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                ++count;
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 요구사항
  방향이 없는 그래프가 주어진다.
  연결 요소 (Connected Component)의 개수를 구한다.
  연결 요소란?
 무향 그래프에서 서로 다른 두 정점이 경로로 연결되어 있으면서 상위 그래프의 추가 정점이 없는 부분 그래프

 입력
 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
 (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
 (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

 출력
 첫째 줄에 연결 요소의 개수를 출력한다.
 */
