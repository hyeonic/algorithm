package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ14888 {

    private static int n;
    private static int[] numbers;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static Map<String, Integer> operators = new HashMap<>();

    private static void backtracking(int depth, int result) {
        if (depth == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (String key : operators.keySet()) {
            if (operators.get(key) > 0) {
                operators.put(key, operators.get(key) - 1);
                switch (key) {
                    case "+":
                        backtracking(depth + 1, result + numbers[depth]);
                        break;
                    case "-":
                        backtracking(depth + 1, result - numbers[depth]);
                        break;
                    case "*":
                        backtracking(depth + 1, result * numbers[depth]);
                        break;
                    case "/":
                        backtracking(depth + 1, result / numbers[depth]);
                        break;
                }
                operators.put(key, operators.get(key) + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 수의 개수 2 <= n <= 11
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        operators.put("+", scanner.nextInt());
        operators.put("-", scanner.nextInt());
        operators.put("*", scanner.nextInt());
        operators.put("/", scanner.nextInt());

        backtracking(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }
}