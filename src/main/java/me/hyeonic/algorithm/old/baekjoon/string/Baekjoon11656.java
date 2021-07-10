package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon11656 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();
        List<String> dictionary = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            dictionary.add(word.substring(i));
        }

        Collections.sort(dictionary);

        for (String s : dictionary) {
            bufferedWriter.write(s + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
