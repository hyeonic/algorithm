package me.hyeonic.algorithm.programmers.level2.stackqueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers42587 {

    public static int solution(int[] priorities, int location) {

        Queue<Integer> queue = new LinkedList<>();
        for (int priority : priorities) {
            queue.offer(priority);
        }

        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            indexQueue.offer(i);
        }

        int count = 0; // print 될 때 마다 count
        while (!queue.isEmpty()) {

            Integer peek = queue.peek();
            Integer indexPeek = indexQueue.peek();

            int max = Collections.max(queue);

            if (max == peek) {
                Integer poll = queue.poll();
                Integer indexPoll = indexQueue.poll();
                ++count;

                if (indexPoll == location) break;
            } else {
                queue.offer(queue.poll());
                indexQueue.offer(indexQueue.poll());
            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
