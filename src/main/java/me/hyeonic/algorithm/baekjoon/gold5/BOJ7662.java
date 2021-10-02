package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.Scanner;
import java.util.TreeMap;

public class BOJ7662 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int k = scanner.nextInt(); // 연산의 개수

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String command = scanner.next();
                int number = scanner.nextInt();

                if (command.equals("I")) {
                    treeMap.put(number, treeMap.getOrDefault(number, 0) + 1);
                } else if (command.equals("D") && !treeMap.isEmpty()) {
                    if (number == 1) {
                        int maxKey = treeMap.lastKey();
                        if (treeMap.get(maxKey) > 1) {
                            treeMap.put(maxKey, treeMap.get(maxKey) - 1);
                        } else {
                            treeMap.remove(maxKey);
                        }
                    } else if (number == -1) {
                        int minKey = treeMap.firstKey();
                        if (treeMap.get(minKey) > 1) {
                            treeMap.put(minKey, treeMap.get(minKey) - 1);
                        } else {
                            treeMap.remove(minKey);
                        }
                    }
                }
            }

            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}