package me.hyeonic.algorithm.baekjoon.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1158 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) queue.offer(i);

        StringBuilder stringBuilder = new StringBuilder("<");
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                stringBuilder.append(queue.poll() + ">");
                break;
            }

            for (int i = 0; i < k - 1; i++)
                queue.offer(queue.poll());

            stringBuilder.append(queue.poll() + ", ");
        }

        bufferedWriter.write(stringBuilder.toString());

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}