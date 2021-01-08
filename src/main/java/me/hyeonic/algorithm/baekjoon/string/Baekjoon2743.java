package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;

public class Baekjoon2743 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        bufferedWriter.write(String.valueOf(s.length()));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
