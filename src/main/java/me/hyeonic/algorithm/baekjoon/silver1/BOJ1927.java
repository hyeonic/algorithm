package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1927 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x == 0 && !priorityQueue.isEmpty()) {
                stringBuilder.append(priorityQueue.poll()).append("\n");
            } else if (x == 0 && priorityQueue.isEmpty()) {
                stringBuilder.append("0\n");
            } else {
                priorityQueue.add(x);
            }
        }

        System.out.println(stringBuilder);
    }
}