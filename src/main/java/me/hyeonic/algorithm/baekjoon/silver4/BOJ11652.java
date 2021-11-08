package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BOJ11652 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long key = scanner.nextLong();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (long key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        List<Long> list = new ArrayList<>();
        for (long key : map.keySet()) {
            if (max == map.get(key)) {
                list.add(key);
            }
        }

        list.sort(Comparator.naturalOrder());

        System.out.println(list.get(0));
    }
}