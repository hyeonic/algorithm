package me.hyeonic.algorithm.baekjoon.silver3;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ2407 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BigInteger number1 = BigInteger.ONE;
        BigInteger number2 = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            number1 = number1.multiply(new BigInteger(String.valueOf(n - i)));
            number2 = number2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        System.out.println(number1.divide(number2));
    }
}