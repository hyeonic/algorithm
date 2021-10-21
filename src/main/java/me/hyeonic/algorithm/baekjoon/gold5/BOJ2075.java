package me.hyeonic.algorithm.baekjoon.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n * n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            String[] row = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                array[index++] = Integer.parseInt(row[j]);
            }
        }

        Arrays.sort(array);

        System.out.println(array[n * n - n]);
    }
}

class BOJ2075PQ {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순

        for (int i = 0; i < n; i++) {
            String[] row = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                priorityQueue.add(Integer.parseInt(row[j]));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            priorityQueue.poll();
        }

        System.out.println(priorityQueue.poll());
    }
}