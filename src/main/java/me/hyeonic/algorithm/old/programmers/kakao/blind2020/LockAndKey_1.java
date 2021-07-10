package me.hyeonic.algorithm.old.programmers.kakao.blind2020;

public class LockAndKey_1 {

    static int get(int[][] a, int rotation, int row, int col) {
        // 현재 위치를 넣고, 돌렸을 때 값이 들어 있는 위치의 값을 반환하는 메소드
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

    static void print(int[][] a, int rotation) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a.length; col++) {
                System.out.printf("%2d", get(a, rotation, row, col)); // 90도 회전했을 때 (0, 0)을 get
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int rotation = 0; rotation < 360; rotation += 90) {
            print(a, rotation);
        }
    }
}
