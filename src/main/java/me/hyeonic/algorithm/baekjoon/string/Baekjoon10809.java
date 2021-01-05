package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon10809 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] word = bufferedReader.readLine().split("");
        Map<Character, Integer> indexMap = new HashMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < word.length; i++) {
            Character character = word[i].charAt(0);
            if (!indexMap.containsKey(character)) indexMap.put(character, i);
        }

        for (int i = 0; i < alphabet.length(); i++) {
            Character character = alphabet.charAt(i);
            if (indexMap.containsKey(character))
                bufferedWriter.write(indexMap.get(character) + " ");
            else
                bufferedWriter.write("-1 ");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}