package me.hyeonic.algorithm.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(numbers);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(numbers[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}

class BOJ10989Counting {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] count = new int[10_001];

        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(bufferedReader.readLine())]++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                stringBuilder.append(i).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}