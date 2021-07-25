package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1021 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int totalCount = 0;
        for (int i = 0; i < m; i++) {
            int target = scanner.nextInt();
            int frontCount = 0;
            Deque<Integer> frontDeque = new LinkedList<>(deque);
            while (!frontDeque.isEmpty()) {
                Integer number = frontDeque.peekFirst();
                if (target == number) {
                    frontDeque.pollFirst();
                    break;
                } else {
                    frontDeque.addLast(frontDeque.pollFirst());
                    frontCount++;
                }
            }

            int backCount = 0;
            Deque<Integer> backDeque = new LinkedList<>(deque);
            while (!backDeque.isEmpty()) {
                Integer number = backDeque.peekFirst();
                if (target == number) {
                    backDeque.pollFirst();
                    break;
                } else {
                    backDeque.addFirst(backDeque.pollLast());
                    backCount++;
                }
            }

            if (frontCount > backCount) {
                totalCount += backCount;
                deque = new LinkedList<>(backDeque);
            } else {
                totalCount += frontCount;
                deque = new LinkedList<>(frontDeque);
            }
        }

        System.out.println(totalCount);
    }
}