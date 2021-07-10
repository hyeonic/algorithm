package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.*;

public class Baekjoon1100 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] chessBoard = new String[8];

        for (int i = 0; i < chessBoard.length; i++) {
            String row = bufferedReader.readLine();
            chessBoard[i] = row;
        }

        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0 && chessBoard[i].charAt(j) == 'F') {
                    ++count;
                }
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
