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

            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                String[] clothe = scanner.nextLine().split(" ");
                clothes.put(clothe[1], clothes.getOrDefault(clothe[1], 0) + 1);
            }

            int mul = 1;
            for (String key : clothes.keySet()) {
                mul *= clothes.get(key) + 1;
            }

            System.out.println(mul - 1);
        }
    }
}