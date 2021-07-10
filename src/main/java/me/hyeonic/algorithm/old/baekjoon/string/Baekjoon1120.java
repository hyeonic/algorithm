package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1120 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        String a = input[0];
        String b = input[1];

        int max = 0;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            String substringB = b.substring(i, i + a.length());
            int sameCount = 0;
            for (int j = 0; j < substringB.length(); j++) {
                if (a.charAt(j) == substringB.charAt(j)) {
                    ++sameCount;
                }
            }

            if (sameCount > max) max = sameCount;
        }

        System.out.println(a.length() - max);

        bufferedReader.close();
    }
}
