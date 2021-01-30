package me.hyeonic.algorithm.example.dynamicprogramming;

public class Fibonacci {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}