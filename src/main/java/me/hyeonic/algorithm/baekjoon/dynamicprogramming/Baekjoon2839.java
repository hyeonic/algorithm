package me.hyeonic.algorithm.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2839 {

    public static int count(int weight) {

        int length = weight / 3;

        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                if (weight == i * 3 + j * 5) { // 가장 먼저 알맞게 계산된 설탕 봉지의 개수를 반환한다.
                    return i + j;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int weight = Integer.parseInt(bufferedReader.readLine()); // 설탕 무게
        int count = count(weight);

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();

    }
}