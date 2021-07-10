package me.hyeonic.algorithm.old.baekjoon.greedy;

import java.io.*;

public class Baekjoon1080 {

    public static BufferedReader bufferedReader;
    public static BufferedWriter bufferedWriter;

    public static int[][] matrixA;
    public static int[][] matrixB;

    public static void setMatrix(int[][] matrix, int n, int m) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] rows = bufferedReader.readLine().split("");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(rows[j]);
            }
        }
    }

    public static void reverse(int[][] matrix, int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    public static boolean IsSameMatrix() {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%2d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputSplit = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(inputSplit[0]);
        int m = Integer.parseInt(inputSplit[1]);

        matrixA = new int[n][m];
        matrixB = new int[n][m];

        setMatrix(matrixA, n, m);
        setMatrix(matrixB, n, m);

        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m -3; j++) {
                if (matrixA[i][j] == matrixB[i][j]) continue;
                ++count;
                reverse(matrixA, i, j);
            }
        }

        if (!IsSameMatrix()) count = -1;

        System.out.println();
        print(matrixA);
        print(matrixB);

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
