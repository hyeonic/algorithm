package me.hyeonic.algorithm.baekjoon.greedy;

import java.io.*;

public class Baekjoon11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputSplit = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(inputSplit[0]); // 동전의 종류 개수
        int k = Integer.parseInt(inputSplit[1]); // 동전 가치의 합

        int[] monies = new int[n];

        for (int i = 0; i < monies.length; i++) {
            monies[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count += k / monies[i];
            k %= monies[i];
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}