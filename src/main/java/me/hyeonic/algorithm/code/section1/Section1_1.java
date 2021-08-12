package me.hyeonic.algorithm.code.section1;

import java.util.Scanner;

public class Section1_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        char c = scanner.next().toUpperCase().charAt(0);

        int count = 0;
        for (char ch : s.toUpperCase().toCharArray()) {
            if (c == ch) {
                count++;
            }
        }

        System.out.println(count);
    }
}