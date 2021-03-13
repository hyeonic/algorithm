package me.hyeonic.algorithm.programmers.level2.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers42748 {

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        int count = 0;
        for (int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int index = command[2];

            List<Integer> temp = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                temp.add(array[i - 1]);
            }
            Collections.sort(temp);
            answer[count++] = temp.get(index - 1);
        }
        return answer;
    }

    public static void main(String[] args) {

        solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}
