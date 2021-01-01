package me.hyeonic.algorithm.programmers.kakao.blind2020;

public class LockAndKey_solution {

    static int getKey(int[][] key, int rotation, int rowMove, int colMove, int row, int col) {

        row -= rowMove;
        col -= colMove;

        if (row < 0 || key.length - 1 < row) return 0;
        if (col < 0 || key.length - 1 < col) return 0;
        if (rotation == 90) {
            int temp = row;
            row = key.length - 1 - col;
            col = temp;
        } else if (rotation == 180) {
            row = key.length - 1 - row;
            col = key.length - 1 - col;
        } else if (rotation == 270) {
            int temp = row;
            row = col;
            col = key.length - 1 - temp;
        }
        return key[row][col];
    }

    static boolean isKey(int[][] lock, int[][] key, int rotation, int rowMove, int colMove) {

        for (int row = 0; row < lock.length; row++) {
            for (int col = 0; col < lock.length; col++) {
                if (getKey(key, rotation, rowMove, colMove, row, col) == lock[row][col])
                    return false;
            }
        }
        return true;
    }

    public static boolean solution(int[][] key, int[][] lock) {

        for (int rotation = 0; rotation < 360; rotation += 90) {
            for (int rowMove = -(key.length - 1); rowMove < lock.length; rowMove++) {
                for (int colMove = -(key.length - 1); colMove < lock.length; colMove++) {
                    if (isKey(lock, key, rotation, rowMove, colMove)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }
}
