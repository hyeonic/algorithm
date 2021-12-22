package me.hyeonic.algorithm.baekjoon.silver2;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BOJ15663 {
    private static int n;
    private static int m;
    private static boolean[] visited;
    private static List<Integer> numbers;
    private static Set<String> results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        visited = new boolean[n];
        numbers = new ArrayList<>();
        results = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        numbers.sort(Comparator.naturalOrder());

        backtracking(0, new int[m]);

        results.forEach(System.out::println);
    }

    private static void backtracking(int depth, int[] values) {
        if (depth == m) {
            String result = Arrays.stream(values)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
            results.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            values[depth] = numbers.get(i);
            backtracking(depth + 1, values);
            visited[i] = false;
        }
    }
}
