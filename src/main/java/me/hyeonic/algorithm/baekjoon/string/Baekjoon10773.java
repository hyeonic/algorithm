package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;
import java.util.LinkedList;

public class Baekjoon10773 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        int result = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int currentMoney = Integer.parseInt(bufferedReader.readLine());

            if (currentMoney == 0) {
                linkedList.pollLast();
            } else {
                linkedList.add(currentMoney);
            }
        }

        for (Integer value : linkedList) {
            result += value;
        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
