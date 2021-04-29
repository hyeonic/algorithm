package me.hyeonic.algorithm.thisiscodingtest.chapter4;

import java.util.Scanner;

public class Example4_1 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] moveTypes = {"L", "R", "U", "D"};
        sc.nextLine();
        String[] words = sc.nextLine().split(" ");
        int x = 1;
        int y = 1;

        for (String word : words) {
            for (int j = 0; j < 4; j++) {
                if (moveTypes[j].equals(word)) {
                    if (isLocation(dx[j] + x, dy[j] + y)) {
                        x += dx[j];
                        y += dy[j];
                    }
                }
            }
        }
        System.out.println(x + " " + y);
    }

    private static boolean isLocation(int x, int y) {
        if (x > 0 && x <= n && y > 0 && y <= n) return true;
        else return false;
    }
}

/*
input
5
R R R U D D

output
3 4
*/