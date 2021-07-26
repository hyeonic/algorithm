package me.hyeonic.algorithm.baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] commands = bufferedReader.readLine().split(" ");
            if (commands[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(commands[1]));
            } else if (commands[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(commands[1]));
            } else if (commands[0].equals("pop_front")) {
                stringBuilder.append(deque.isEmpty() ? "-1" : deque.pollFirst()).append("\n");
            } else if (commands[0].equals("pop_back")) {
                stringBuilder.append(deque.isEmpty() ? "-1" : deque.pollLast()).append("\n");
            } else if (commands[0].equals("size")) {
                stringBuilder.append(deque.size()).append("\n");
            } else if (commands[0].equals("empty")) {
                stringBuilder.append(deque.isEmpty() ? "1" : "0").append("\n");
            } else if (commands[0].equals("front")) {
                stringBuilder.append(deque.isEmpty() ? "-1" : deque.peekFirst()).append("\n");
            } else if (commands[0].equals("back")) {
                stringBuilder.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}