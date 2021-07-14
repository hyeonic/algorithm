package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10773 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            int number = scanner.nextInt();
            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        int sum = stack.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}