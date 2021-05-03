package me.hyeonic.algorithm.thisiscodingtest.chapter4;

import java.util.Scanner;

public class Practice4_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0';
        int col = inputData.charAt(0) - 'a' + 1;

        System.out.println("row: " + row + " col: " + col);

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
//        int[][] steps = {
//                {-2, -1},
//                {-1, -2},
//                {1, -2},
//                {2, -1},
//                {2, 1},
//                {1, 2},
//                {-1, 2},
//                {-2, 1}
//        };

        int result = 0;
        for (int i = 0; i < 8; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (isLocation(nextRow, nextCol)) {
                result += 1;
            }
        }

        System.out.println(result);
    }

    private static boolean isLocation(int row, int col) {
        if (row >= 1 && row <= 8 && col >= 1 && col <= 8) {
            return true;
        } else {
            return false;
        }
    }
}

/*
input
a1

output
2
*/