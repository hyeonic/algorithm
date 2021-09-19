package me.hyeonic.algorithm.baekjoon.gold4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1715 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(scanner.nextInt());
        }

        int sum = 0;
        while (priorityQueue.size() > 1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();

            sum += (a + b);
            priorityQueue.add(a + b);
        }

        System.out.println(sum);
    }
}