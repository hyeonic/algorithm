package me.hyeonic.algorithm.old.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(input[0]); // 문서의 개수
            int m = Integer.parseInt(input[1]);
            // 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수

            Queue<Integer> printQueue = new LinkedList<>();
            Queue<Integer> indexQueue = new LinkedList<>();
            input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                printQueue.offer(Integer.parseInt(input[j]));
                indexQueue.offer(j);
            }

            int count = 0;
            while (!printQueue.isEmpty()) {
                Integer priority = printQueue.peek();
                Integer indexPeek = indexQueue.peek();

                int max = Collections.max(printQueue);

                if (max == priority) {
                    printQueue.poll();
                    Integer indexPoll = indexQueue.poll();
                    count++;

                    if (indexPoll == m) break;
                } else {
                    printQueue.offer(printQueue.poll());
                    indexQueue.offer(indexQueue.poll());
                }
            }
            bufferedWriter.write(count + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}