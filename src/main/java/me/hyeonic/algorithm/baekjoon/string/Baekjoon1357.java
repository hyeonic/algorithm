package me.hyeonic.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1357 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        String x = input[0];
        String y = input[1];

        x = rev(x);
        y = rev(y);

        int intResult = Integer.parseInt(x) + Integer.parseInt(y);
        String stringResult = rev(String.valueOf(intResult));

        System.out.println(Integer.parseInt(stringResult));

        bufferedReader.close();
    }

    private static String rev(String x) {

        StringBuilder reverseX = new StringBuilder();
        for (int i = x.length() - 1; i >= 0; i--)
            reverseX.append(x.charAt(i));

        return reverseX.toString();
    }
}