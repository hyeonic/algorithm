package me.hyeonic.algorithm.programmers;

import java.util.Arrays;

public class P43238 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long)n * times[times.length - 1];

        long result = 0L;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0; // 총 심사 인원
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P43238 p43238 = new P43238();

        System.out.println(p43238.solution(6, new int[] {7, 10}));
    }
}