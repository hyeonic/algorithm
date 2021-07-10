package me.hyeonic.algorithm.old.programmers.level2.heap;

import java.util.PriorityQueue;

public class Programmers42626 {

    public static int solution(int[] scoville, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville)
            queue.offer(i);

        int count = 0;
        while (queue.peek() < k && queue.size() >= 2) {
            int mixed = queue.poll() + (queue.poll() * 2);
            queue.add(mixed);
            ++count;
        }

        if (queue.peek() < k) count = -1;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}