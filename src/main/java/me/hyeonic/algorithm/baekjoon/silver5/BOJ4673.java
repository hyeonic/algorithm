package me.hyeonic.algorithm.baekjoon.silver5;

public class BOJ4673 {

    public static void main(String[] args) {

        boolean[] isConstructor = new boolean[10_001];

        for (int i = 1; i <= 10_000; i++) {
            if (d(i) <= 10_000) {
                isConstructor[d(i)] = true;
            }
        }

        for (int i = 1; i <= 10_000; i++) {
            if (!isConstructor[i]) {
                System.out.println(i);
            }
        }
    }

    private static int d(int n) {
        String[] digits = String.valueOf(n).split("");

        int sum = n;
        for (String digit : digits) {
            sum += Integer.valueOf(digit);
        }

        return sum;
    }
}