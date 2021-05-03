package me.hyeonic.algorithm.thisiscodingtest.chapter5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Example5_2 {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        queue.offer(5);
        queue.offer(2);
        queue.offer(3);
        queue.offer(7);
        queue.poll();
        queue.offer(1);
        queue.offer(4);
        queue.poll();

        queue.forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();

        Deque<Integer> deque = new LinkedList<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        deque.offerLast(5);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(7);
        deque.pollFirst();
        deque.offerLast(1);
        deque.offerLast(4);
        deque.pollFirst();

        deque.forEach(integer -> System.out.print(integer + " "));

        System.out.println();

        while (!deque.isEmpty()) {
            System.out.print(deque.poll() + " ");
        }
        System.out.println();

    }
}