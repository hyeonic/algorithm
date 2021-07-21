package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;
import java.util.Stack;

public class BOJ4949 {

    private static boolean isBalance(String text) {
        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String text = scanner.nextLine();
            if (text.equals(".")) {
                break;
            }

            if (isBalance(text)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}