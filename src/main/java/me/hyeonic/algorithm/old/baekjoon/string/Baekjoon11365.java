package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baekjoon11365 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String words = bufferedReader.readLine();

        while (!words.equals("END")) {
            List<String> wordList = Arrays.asList(words.split(""));
            Collections.reverse(wordList);
            bufferedWriter.write(String.join("", wordList) + "\n");
            words = bufferedReader.readLine();
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
