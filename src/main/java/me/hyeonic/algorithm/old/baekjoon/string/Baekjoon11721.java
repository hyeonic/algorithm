package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.*;

public class Baekjoon11721 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();

        for (int i = 0; i < word.length(); i++) {
            if (i % 10 == 0 && i != 0) {
                bufferedWriter.write( "\n" + word.charAt(i));
            } else bufferedWriter.write(word.charAt(i));
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}