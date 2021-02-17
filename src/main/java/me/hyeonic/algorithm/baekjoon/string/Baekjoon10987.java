package me.hyeonic.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Baekjoon10987 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        String word = bufferedReader.readLine();

        int count = 0;
        for (int i = 0; i < word.length(); i++)
            if (vowels.contains(word.charAt(i))) ++count;

        System.out.println(count);

        bufferedReader.close();
    }
}