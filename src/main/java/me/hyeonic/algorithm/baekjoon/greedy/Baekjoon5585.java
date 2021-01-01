package me.hyeonic.algorithm.baekjoon.greedy;

import java.io.*;

public class Baekjoon5585 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int money = Integer.parseInt(bufferedReader.readLine()); // 물건의 가격
        int[] monies = new int[]{500, 100, 50, 10, 5, 1}; // 잔돈 모음

        int change = 1000 - money; // 거스름 돈

        int count = 0;
        for (int i = 0; i < monies.length; i++) {
            count += change / monies[i];
            change %= monies[i];
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
