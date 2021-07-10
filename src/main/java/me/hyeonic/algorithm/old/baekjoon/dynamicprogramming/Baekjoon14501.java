package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        for (int i = n; i > 0; i--) {
            int index = i + t[i];

            if (index > n + 1) dp[i] = dp[i + 1];
            else dp[i] = Math.max(dp[i + 1], p[i] + dp[index]);
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(dp[1]);
        bufferedReader.close();
    }
}

class Baekjoon14501_dfs {
    private static int n, answer = 0;
    private static int[] t, p;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        t = new int[n + 1];
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        dfs(1, 0);
        System.out.println(answer);
    }

    private static void dfs(int day, int value) {

        // day 가 n + 1 이상이 되면 퇴사를 진행한다.
        if (day >= n + 1) {
            answer = Math.max(answer, value);
            return;
        }

        // today 에 상담을 하는 경우 다음 상담 day 는 n + 1 day 를 넘을 수 없다.
        if (day + t[day] <= n + 1) dfs(day + t[day], value + p[day]);
        // today 에 상담을 하지 않는 경우 다음날로 넘어간다.
        if (day + 1 <= n + 1) dfs(day + 1, value);
    }
}