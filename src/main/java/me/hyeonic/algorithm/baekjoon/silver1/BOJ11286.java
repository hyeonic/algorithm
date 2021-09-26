package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) < Math.abs(o2)) { // 절대값 기준 오름차순
                return -1;
            } else if (Math.abs(o1) == Math.abs(o2) && o1 < o2) {
                return -1;
            }
            return 1;
        });

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