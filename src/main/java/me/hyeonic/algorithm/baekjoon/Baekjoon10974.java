package me.hyeonic.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon10974 {

    static int[] output;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(bufferedReader.readLine());
        int[] array = new int[n];
        output = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(array, n, i, 0);
            visited[i] = false;
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void dfs(int[] array, int n, int start, int depth) {
        output[depth] = start + 1;
        if (depth == n - 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(array, n, i, depth + 1);
            visited[i] = false;
        }
    }
}