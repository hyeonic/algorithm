package me.hyeonic.algorithm.programmers.level2.sort;

import java.util.Arrays;

public class Programmers42747 {

    public static int solution(int[] citations) {

        Arrays.sort(citations);

        int answer = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                answer = citations.length - i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }
}

// https://www.ibric.org/myboard/read.php?Board=news&id=270333