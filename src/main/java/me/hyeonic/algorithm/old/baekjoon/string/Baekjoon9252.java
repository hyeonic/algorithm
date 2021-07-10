package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon9252 {

    private static int[][] dpTable;
    private static String lcs = "";
    private static int max = 0;

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

        bufferedWriter.write(dpTable[a.length() - 1][b.length() - 1] + "\n");

        int x = a.length() - 1; // 6 ACAYKP
        int y = b.length() - 1; // 6 CAPCAK
        StringBuilder stringBuilder = new StringBuilder();
        while (!(x == 0 || y == 0)) {
            if (a.charAt(x) == b.charAt(y)) {
                System.out.println("x: " + x + " | y: " + y + " | string: " + stringBuilder.reverse().toString());
                stringBuilder.append(a.charAt(x));
                --x; --y;
            } else if (dpTable[x][y] == dpTable[x - 1][y]) {
                System.out.println("--x");
                --x;
            } else if (dpTable[x][y] == dpTable[x][y - 1]) {
                System.out.println("--y");
                --y;
            }
        }

        bufferedWriter.write(stringBuilder.reverse().toString());

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
