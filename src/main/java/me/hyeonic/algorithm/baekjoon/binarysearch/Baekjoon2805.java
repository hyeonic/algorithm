package me.hyeonic.algorithm.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2805 {

    static int n, m;
    static int[] trees;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        trees = new int[n];
        int max = 0;

        input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(input[i]);
            max = Math.max(max, trees[i]);
        }

        Arrays.sort(trees);

        long start = 0;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int tree : trees)
                if (tree > mid) sum += tree - mid;

            System.out.println("start : " + start + " | end : " + end + " | mid : " + mid + " | sum : " + sum);

            if (sum >= m) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
        bufferedReader.close();
    }
}