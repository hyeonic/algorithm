package me.hyeonic.algorithm.old.programmers.level2.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers42586 {

    public static List<Integer> solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();

        Queue<Integer> progressesQueue = new LinkedList<>();
        for (int progress : progresses)
            progressesQueue.offer(progress);

        Queue<Integer> speedsQueue = new LinkedList<>();
        for (int speed : speeds)
            speedsQueue.offer(speed);

        while (!progressesQueue.isEmpty() && !speedsQueue.isEmpty()) {

            int count = 0;

            for (int i = 0; i < progressesQueue.size(); i++) {
                int progressPoll = progressesQueue.poll();
                int speedPoll = speedsQueue.poll();

                if (progressPoll + speedPoll >= 100) progressesQueue.offer(100);
                else progressesQueue.offer(progressPoll + speedPoll);

                speedsQueue.offer(speedPoll);
            }

            while (!progressesQueue.isEmpty() && progressesQueue.peek() == 100) {
                ++count;
                progressesQueue.poll();
                speedsQueue.poll();
            }
            if (count != 0) answer.add(count);
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1, 1}));
    }
}