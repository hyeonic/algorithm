package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon10988 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();

        if (word.length() == 1) {
            bufferedWriter.write("1");
        } else {
            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    bufferedWriter.write("0");
                    break;
                }

                if (i == word.length() / 2 - 1) bufferedWriter.write("1");
            }
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}