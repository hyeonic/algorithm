package me.hyeonic.algorithm.baekjoon.bronze2;

public class BOJ15596 {

    long sum(int[] a) {
        long sum = 0;

        for (int i : a) {
            sum += i;
        }

        return sum;
    }
}
