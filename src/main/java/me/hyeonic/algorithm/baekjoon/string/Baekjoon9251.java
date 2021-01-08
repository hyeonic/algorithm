package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;

public class Baekjoon9251 {

    private static int[][] dpTable;

    private static void LCS(Character x, int i, Character y, int j) {
        if (i == 0 || j == 0) dpTable[i][j] = 0;
        else if (x == y) {
            dpTable[i][j] = dpTable[i - 1][j - 1] + 1;
        } else if (x != y) {
            dpTable[i][j] = Math.max(dpTable[i][j - 1], dpTable[i - 1][j]);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = "0" + bufferedReader.readLine();
        String b = "0" + bufferedReader.readLine();
        dpTable = new int[a.length()][b.length()];

        for (int i = 0; i < dpTable.length; i++) {
            for (int j = 0; j < dpTable[0].length; j++) {
                LCS(a.charAt(i), i, b.charAt(j), j);
            }
        }

        bufferedWriter.write(String.valueOf(dpTable[a.length() - 1][b.length() - 1]));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
