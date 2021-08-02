package me.hyeonic.algorithm.baekjoon.bronze4;

import java.util.Scanner;

public class BOJ2588 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        System.out.println((Integer.valueOf(a) * (b.charAt(2) - '0')));
        System.out.println((Integer.valueOf(a) * (b.charAt(1) - '0')));
        System.out.println((Integer.valueOf(a) * (b.charAt(0) - '0')));
        System.out.println((Integer.valueOf(a) * Integer.valueOf(b)));
    }
}