package me.hyeonic.algorithm.thisiscodingtest.chapter5;

import java.util.Stack;

public class Example5_1 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        // 최하단 원소부터 출력
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }

        System.out.println();

        // 최상단 원소부터 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }
}