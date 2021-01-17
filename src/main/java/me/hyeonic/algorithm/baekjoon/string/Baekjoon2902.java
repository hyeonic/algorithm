package me.hyeonic.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2902 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] longType = bufferedReader.readLine().split("-");

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : longType) {
            stringBuilder.append(s.charAt(0));
        }

        bufferedWriter.write(stringBuilder.toString());

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}