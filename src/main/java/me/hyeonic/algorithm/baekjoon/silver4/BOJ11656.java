package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11656 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        String[] array = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            array[i] = word.substring(i);
        }

        Arrays.sort(array);
        for (String s : array) {
            System.out.println(s);
        }
    }
}