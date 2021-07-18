package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;

public class BOJ9012 {

    private static boolean isValidPS(String parenthesis) {
        int count = 0;
        for (int i = 0; i < parenthesis.length(); i++) {
            char c = parenthesis.charAt(i);
            if (c == '(') {
                ++count;
            } else if (c == ')') {
                --count;
            }

            if (count == -1) {
                return false;
            }
        }

        if (count != 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            String parenthesis = scanner.nextLine();
            if (isValidPS(parenthesis)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}