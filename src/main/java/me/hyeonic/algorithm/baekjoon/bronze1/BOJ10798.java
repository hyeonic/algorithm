package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10798 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Queue<String>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String word = scanner.next();
            Queue<String> queue = new LinkedList<>();
            for (char c : word.toCharArray()) {
                queue.add(String.valueOf(c));
            }
            list.add(queue);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (true) {
            for (Queue<String> queue : list) {
                if (!queue.isEmpty()) {
                    stringBuilder.append(queue.poll());
                }
            }

            for (Queue<String> queue : list) {
                if (queue.isEmpty()) {
                    count++;
                }
            }

            if (count == 5) {
                break;
            }

            count = 0;
        }

        System.out.println(stringBuilder);
    }
}