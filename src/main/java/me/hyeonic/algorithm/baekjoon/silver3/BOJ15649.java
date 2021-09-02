package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15649 {

    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        backtracking(0, new ArrayList<>());
    }

    private static void backtracking(int depth, List<Integer> list) {

        if (depth == m) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                backtracking(depth + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}