package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1316 {

    static boolean isGroupWord(String word) {
        List<Character> checked = new ArrayList<>();
        Character prevChar = null;

        for (int j = 0; j < word.length(); j++) {
            Character curChar = word.charAt(j);
            if (checked.contains(curChar)) {
                if (prevChar == curChar) continue;
                else {
                    return false;
                }
            } else {
                checked.add(curChar);
                prevChar = curChar;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        int count = n;
        for (int i = 0; i < n; i++) {
            String word = bufferedReader.readLine();
            if (isGroupWord(word)) continue;
            else --count;
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}