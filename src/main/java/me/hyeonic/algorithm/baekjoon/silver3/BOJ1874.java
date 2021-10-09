package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int start = 0;
        while (n-- > 0) {

            int target = scanner.nextInt();

            if (target > start) {
                for (int i = start + 1; i <= target; i++) {
                    stack.push(i);
                    stringBuilder.append("+\n");
                }
                start = target;
            } else if (stack.peek() != target) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            stringBuilder.append("-\n");
        }

        System.out.println(stringBuilder);
    }
}