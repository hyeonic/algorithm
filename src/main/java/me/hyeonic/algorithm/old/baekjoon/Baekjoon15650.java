package me.hyeonic.algorithm.old.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon15650 {

    static int n, m;
    static boolean[] visited;
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(input[0]); // n 개 중에
        m = Integer.parseInt(input[1]); // m 개를 뽑는 것

        visited = new boolean[n + 1];
        array = new int[m];

        dfs(0);

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void dfs(int depth) {

        if (m == depth) {
            for (int i = 0; i < m; i++)
                System.out.print(array[i] + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && (depth == 0 || array[depth - 1] < i)) {
                    // d == 0 이면 최초의 값이 들어가므로 전부 입력
                    // array[d - 1] < i 이전의 값이 현재값 보다 작은 경우 -> 오름차순 유지
                    visited[i] = true; // 방문
                    array[depth] = i; // 출력할 원소 담기

                    dfs(depth + 1); // 재귀

                    visited[i] = false; // 원복
                }
            }
        }
    }
}