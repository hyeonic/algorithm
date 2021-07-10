package me.hyeonic.algorithm.old.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon14889 {

    static int[][] s; // 능력치 저장을 위한 이차배열
    static boolean[] visited; // 선수들의 명단 체크를 위한 boolean 배열
    static int n;
    static int min = Integer.MAX_VALUE;

    private static void combination(int start, int depth) {
        if (depth == n / 2) {
            min = Math.min(min, getDifference());
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int getDifference() {
        int sumByStartTeam = 0;
        int sumByLinkTeam = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[i] && visited[j]) sumByStartTeam += s[i][j];
                if (!visited[i] && !visited[j]) sumByLinkTeam += s[i][j];
            }
        }

        return Math.abs(sumByStartTeam - sumByLinkTeam);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(bufferedReader.readLine());
        visited = new boolean[n + 1];
        s = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                s[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        combination(1, 0);
        bufferedWriter.write(String.valueOf(min));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}