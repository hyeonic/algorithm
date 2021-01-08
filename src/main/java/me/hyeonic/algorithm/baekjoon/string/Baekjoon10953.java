package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon10953 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            bufferedWriter.write((a + b) + "\n");

        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
