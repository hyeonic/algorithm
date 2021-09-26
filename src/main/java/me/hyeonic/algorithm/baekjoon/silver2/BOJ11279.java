package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11279 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x == 0 && !priorityQueue.isEmpty()) {
                stringBuilder.append(priorityQueue.poll()).append("\n");
            } else if (x == 0) {
                stringBuilder.append("0\n");
            } else {
                priorityQueue.add(x);
            }
        }

        System.out.println(stringBuilder);
    }
}