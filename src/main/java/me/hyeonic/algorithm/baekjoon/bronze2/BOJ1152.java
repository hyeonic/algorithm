package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ1152 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int length = input.length;

        if (length == 0) {
            System.out.println(length);
            return;
        }

        if (input[0].equals("")) {
            length--;
        }

        if (input[input.length - 1].equals("")) {
            length--;
        }

        System.out.println(length);
    }
}
