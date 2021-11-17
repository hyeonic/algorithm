package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ11931 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        list.sort(Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : list) {
            stringBuilder.append(i).append("\n");
        }

        System.out.println(stringBuilder);
    }
}