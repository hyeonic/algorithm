package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BOJ7785 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            String command = scanner.next();

            if (hashSet.contains(name) && command.equals("leave")) {
                hashSet.remove(name);
            } else {
                hashSet.add(name);
            }
        }

        List<String> list = new ArrayList<>(hashSet);
        list.sort(Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (String name : list) {
            stringBuilder.append(name).append("\n");
        }

        System.out.println(stringBuilder);
    }
}