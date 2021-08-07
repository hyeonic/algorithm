package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ2908 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        int reverseA = ((a.charAt(2) - '0') * 100) + ((a.charAt(1) - '0') * 10) + (a.charAt(0) - '0');
        int reverseB = ((b.charAt(2) - '0') * 100) + ((b.charAt(1) - '0') * 10) + (b.charAt(0) - '0');

        System.out.println(Math.max(reverseA, reverseB));
    }
}