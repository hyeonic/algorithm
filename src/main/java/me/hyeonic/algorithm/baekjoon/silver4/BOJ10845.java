package me.hyeonic.algorithm.baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] commands = bufferedReader.readLine().split(" ");
            if (commands[0].equals("push")) {
                queue.add(Integer.valueOf(commands[1]));
            } else if (commands[0].equals("pop")) {
                stringBuilder.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
            } else if (commands[0].equals("size")) {
                stringBuilder.append(queue.size()).append("\n");
            } else if (commands[0].equals("empty")) {
                stringBuilder.append(queue.isEmpty() ? "1" : "0").append("\n");
            } else if (commands[0].equals("front")) {
                stringBuilder.append(queue.isEmpty() ? "-1" : queue.getFirst()).append("\n");
            } else if (commands[0].equals("back")) {
                stringBuilder.append(queue.isEmpty() ? "-1" : queue.getLast()).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}