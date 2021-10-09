package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10799 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;
        char prev = ' ';
        for (char c : words.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                prev = c;
                continue;
            }

            if (c == ')') {
                stack.pop();
                if (prev == '(') {
                    count += stack.size();
                } else {
                    count++;
                }
                prev = c;
            }
        }

        System.out.println(count);
    }
}