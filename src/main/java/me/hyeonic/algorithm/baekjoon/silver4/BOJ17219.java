package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ17219 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Map<String, String> passwords = new HashMap<>();
        for (int i = 0; i < n; i++) {
            passwords.put(scanner.next(), scanner.next());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stringBuilder.append(passwords.get(scanner.next())).append("\n");
        }

        System.out.println(stringBuilder);
    }
}