package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;
import java.util.Stack;

public class BOJ17413 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        boolean flag = false;
        for (char c : word.toCharArray()) {
            if (c == '<') {
                flag = true;
            }

            if (flag || c == ' ') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(c);
            } else {
                stack.push(c);
            }

            if (c == '>') {
                flag = false;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
