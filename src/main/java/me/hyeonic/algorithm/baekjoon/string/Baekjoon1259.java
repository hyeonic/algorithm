package me.hyeonic.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1259 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine();

        while (!word.equals("0")) {

            if (word.length() == 1) {
                bufferedWriter.write("yes\n");
            } else {
                for (int i = 0; i < word.length() / 2; i++) {
                    if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                        bufferedWriter.write("no\n");
                        break;
                    }

                    if (i == word.length() / 2 - 1) bufferedWriter.write("yes\n");
                }
            }
            word = bufferedReader.readLine();
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
