package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ2504 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int count = 1;
        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            if (bracket == '(' ) {
                stack.push(bracket);
                count *= 2;
            } else if (bracket == '[') {
                stack.push(bracket);
                count *= 3;
            } else {
                if (bracket == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        break;
                    }

                    if (brackets.charAt(i - 1) == '(') {
                        result += count;
                    }

                    stack.pop();
                    count = count / 2;
                } else if (bracket == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        break;
                    }

                    if (brackets.charAt(i - 1) == '[') {
                        result += count;
                    }

                    stack.pop();
                    count = count / 3;
                }
            }

            System.out.println("bracket -> " + bracket + " count -> " + count + " result -> " + result);
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(result);
    }
}