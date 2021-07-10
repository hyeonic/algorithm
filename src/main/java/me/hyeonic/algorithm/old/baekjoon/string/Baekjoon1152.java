package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.*;

public class Baekjoon1152 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] words = bufferedReader.readLine().split(" ");

        int count = 0;
        for (String word : words) {
            if (!word.equals("")) ++count;
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
