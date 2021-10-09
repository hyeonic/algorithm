package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ9375 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {

            int n = scanner.nextInt();
            Map<String, Integer> clothes = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                String clothe = scanner.next();
                clothes.put(clothe, clothes.getOrDefault(clothe, 0) + 1);
            }

            int mul = 1;
            for (String key : clothes.keySet()) {
                mul *= clothes.get(key) + 1;
            }

            System.out.println(mul - 1);
        }
    }
}