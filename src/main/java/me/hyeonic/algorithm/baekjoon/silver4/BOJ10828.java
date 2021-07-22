package me.hyeonic.algorithm.baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] commands = bufferedReader.readLine().split(" ");
            if (commands[0].equals("push")) {
                stack.push(Integer.valueOf(commands[1]));
            } else if (commands[0].equals("pop")) {
                stringBuilder.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n");
            } else if (commands[0].equals("size")) {
                stringBuilder.append(stack.size()).append("\n");
            } else if (commands[0].equals("empty")) {
                stringBuilder.append(stack.isEmpty() ? "1" : "0").append("\n");
            } else if (commands[0].equals("top")) {
                stringBuilder.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}