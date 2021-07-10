package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1032 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] files = new String[n];

        for (int i = 0; i < n; i++) {
            files[i] = bufferedReader.readLine();
        }

        boolean isSame;
        for (int i = 0; i < files[0].length(); i++) {
            isSame = true;
            for (int j = 1; j < n ; j++) {
                if (files[0].charAt(i) != files[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) bufferedWriter.write("?");
            else bufferedWriter.write(files[0].charAt(i));
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}