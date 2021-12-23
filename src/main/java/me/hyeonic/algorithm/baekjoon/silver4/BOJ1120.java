package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;

public class BOJ1120 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        System.out.println(getMinDifferenceCount(a, b));
    }

    private static int getMinDifferenceCount(String a, String b) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < b.length() - a.length() + 1; i++) {
            int count = getDifferenceCount(a, b.substring(i, a.length() + i));
            min = Math.min(min, count);
        }

        return min;
    }

    private static int getDifferenceCount(String string, String otherString) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != otherString.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
