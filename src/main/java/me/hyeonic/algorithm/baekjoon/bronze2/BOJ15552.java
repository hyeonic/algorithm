package me.hyeonic.algorithm.baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15552 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String[] numbers = bufferedReader.readLine().split(" ");
            bufferedWriter.write(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]) + "\n");
        }

        bufferedWriter.flush();
    }
}