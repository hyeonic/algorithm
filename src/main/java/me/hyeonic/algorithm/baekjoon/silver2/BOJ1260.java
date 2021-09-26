package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {

    public static int[][] array;
    public static boolean[] visited;

    private static void dfs(int v) {
        // 현재 노드 방문 처리
        visited[v] = true;
        System.out.print(v + " ");
        // 현재 노드와 연결된 다른 노드 재귀적 방문
        for (int i = 0; i < array[v].length; i++) {
            if (array[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        // 현재 노드 방문 처리
        visited[v] = true;
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            v = queue.poll();
            System.out.print(v + " ");
            // 해당 원소와 연결된, 방문하지 않은 원소 큐에 삽입
            for (int i = 0; i < array[v].length; i++) {
                if (array[v][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();

        // 그래프 초기화
        array = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            array[x][y] = 1;
            array[y][x] = 1;
        }

        dfs(v);
        visited = new boolean[n + 1];
        System.out.println();
        bfs(v);
    }
}