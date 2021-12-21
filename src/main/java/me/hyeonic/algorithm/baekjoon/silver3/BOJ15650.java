package me.hyeonic.algorithm.baekjoon.silver3;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ15650 {
    private static int n;
    private static int m;
    private static boolean[] visited;
    private static List<String> results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        visited = new boolean[n + 1];
        results = new ArrayList<>();

        backtracking(0, 1, new int[m]);

        results.forEach(System.out::println);
    }

    private static void backtracking(int depth, int start, int[] values) {
        if (depth == m) {
            String result = Arrays.stream(values)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
            results.add(result);
            return;
        }

        for (int i = start; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            values[depth] = i;
            backtracking(depth + 1, i, values);
            visited[i] = false;
        }
    }
}