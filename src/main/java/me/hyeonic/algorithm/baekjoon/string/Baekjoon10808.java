package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon10808 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String word = bufferedReader.readLine();
        Map<Character, Integer> alphabetMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (alphabetMap.containsKey(character)) {
                alphabetMap.put(character, alphabetMap.get(character) + 1);
            } else {
                alphabetMap.put(character, 1);
            }
        }

        for (int i = 0; i < alphabet.length(); i++) {
            Character character = alphabet.charAt(i);

            if (alphabetMap.containsKey(character)) {
                bufferedWriter.write(alphabetMap.get(character) + " ");
            } else {
                bufferedWriter.write( "0 ");
            }
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}