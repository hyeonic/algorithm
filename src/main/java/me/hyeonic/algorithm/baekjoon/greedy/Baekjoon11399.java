package me.hyeonic.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;

public class Baekjoon11399 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] withdrawalTimes = new int[n];
        String[] inputSplit = bufferedReader.readLine().split(" ");
        for( int i = 0; i < n; ++i ) {
            withdrawalTimes[i] = Integer.parseInt(inputSplit[i]);
        }

        Arrays.sort(withdrawalTimes);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += withdrawalTimes[i] * (n - i);
        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();

    }
}
