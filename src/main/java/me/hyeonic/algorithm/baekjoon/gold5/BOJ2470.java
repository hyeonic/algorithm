package me.hyeonic.algorithm.baekjoon.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        List<Integer> solutions = new ArrayList<>();
        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            solutions.add(Integer.parseInt(input[i]));
        }

        solutions.sort(Comparator.naturalOrder()); // 오름차순 정렬

        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;
        int acid = Integer.MAX_VALUE;
        int alkali = Integer.MIN_VALUE;
        while (start < end) {
            int sum = solutions.get(start) + solutions.get(end);

            if (Math.abs(sum) < min) {
                alkali = solutions.get(start);
                acid = solutions.get(end);
                min = Math.abs(sum);
            }

            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(alkali + " " + acid);
    }
}