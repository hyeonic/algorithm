package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1935 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 피연산자의 개수 1 <= n <= 26
        String postfix = scanner.next();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put((char) ('A' + i), scanner.nextInt());
        }

        Stack<Double> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                stack.push(Double.valueOf(map.get(c)));
            } else {
                double a = stack.pop();
                double b = stack.pop();
                if (c == '+') {
                    stack.push(b + a);
                } else if (c == '-') {
                    stack.push(b - a);
                } else if (c == '*') {
                    stack.push(b * a);
                } else {
                    stack.push(b / a);
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}