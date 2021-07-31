package me.hyeonic.algorithm.thisiscodingtest.chapter07;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Practice7_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }

        System.out.println(set);

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            if (set.contains(scanner.nextInt())) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}

/*
입력
5
8 3 7 9 2
3
5 7 9

출력
no yes yes
*/