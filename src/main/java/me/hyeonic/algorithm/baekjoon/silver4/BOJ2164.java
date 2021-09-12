package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        boolean flag = true;
        while (queue.size() != 1) {

            if (flag) {
                queue.poll();
                flag = false;
                continue;
            }

            queue.offer(queue.poll());
            flag = true;
        }

        System.out.println(queue.poll());
    }
}