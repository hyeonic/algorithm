package me.hyeonic.algorithm.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1654 {

    static int[] wires;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        int k = Integer.parseInt(input[0]); // 랜선의 개수
        int n = Integer.parseInt(input[1]); // 필요한 랜선의 개수
        wires = new int[k];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            wires[i] = Integer.parseInt(bufferedReader.readLine());
            max = Math.max(max, wires[i]);
        }

        Arrays.sort(wires); // 오름차순 정렬

        long start = 1;
        long end = max;

        while (start <= end) {

            long mid = (start + end) / 2;
            int count = 0;

            for (int wire : wires)
                count += wire / mid;

            System.out.println("start : " + start + " | end : " + end + " | mid : " + mid + " | count : " + count);

            if (count >= n) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
        bufferedReader.close();
    }
}