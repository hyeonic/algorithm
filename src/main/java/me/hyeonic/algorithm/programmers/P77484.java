package me.hyeonic.algorithm.programmers;

import java.util.Arrays;
import java.util.HashSet;

public class P77484 {

    public int[] solution(int[] lottoNumbers, int[] winNums) {

        HashSet<Integer> hashSet = new HashSet<>();

        int zeroCount = 0;
        for (Integer number : lottoNumbers) {
            if (number == 0) {
                zeroCount++;
                continue;
            }

            hashSet.add(number);
        }

        int same = 0;
        for (int winNum : winNums) {
            if (hashSet.contains(winNum)) {
                same++;
            }
        }

        int maxRank = 7 - (same + zeroCount);
        int minRank = 7 - same;

        if (maxRank > 6) {
            maxRank = 6;
        }

        if (minRank > 6) {
            minRank = 6;
        }

        return new int[]{maxRank, minRank};
    }

    public static void main(String[] args) {
        P77484 p77484 = new P77484();

        int[] solution = p77484.solution(
                new int[]{44, 1, 0, 0, 31, 25},
                new int[]{31, 10, 45, 1, 6, 19}
        );

        System.out.println(Arrays.toString(solution));

        solution = p77484.solution(
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{38, 19, 20, 40, 15, 25}
        );

        System.out.println(Arrays.toString(solution));

        solution = p77484.solution(
                new int[]{45, 4, 35, 20, 3, 9},
                new int[]{20, 9, 3, 45, 4, 35}
        );

        System.out.println(Arrays.toString(solution));
    }
}