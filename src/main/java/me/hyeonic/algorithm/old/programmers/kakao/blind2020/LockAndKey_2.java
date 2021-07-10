package me.hyeonic.algorithm.old.programmers.kakao.blind2020;

public class LockAndKey_2 {

    static int get(int[][] a, int rotation, int rowMove, int colMove, int row, int col) {

        row -= rowMove;
        col -= colMove;

        if (row < 0 || a.length - 1 < row) return 0; // 범위를 넘어가면
        if (col < 0 || a.length - 1 < col) return 0; // 범위를 넘어가면

        if (rotation == 90) {
            int temp = row;
            row = a.length - 1 - col;
            col = temp;
        } else if (rotation == 180) {
            row = a.length - 1 - row;
            col = a.length - 1 - col;
        } else if (rotation == 270) {
            int temp = row;
            row = col;
            col = a.length - 1 - temp;
        }
        return a[row][col];
    }

    static void print(int[][] key, int rotation, int rowMove, int colMove) {
        for (int row = -2; row < key.length + 2; row++) {
            for (int col = -2; col < key.length + 2; col++) {
                int k = get(key, rotation, rowMove, colMove, row, col);
                System.out.printf("%2s", k > 0 ? String.valueOf(k) : ".");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int rotation = 0; rotation < 360; rotation += 90) {
            System.out.println("--------------------");
            for (int move = -a.length + 1; move < a.length; move++) {
                print(a, rotation, move, move);
            }
        }
    }
}
