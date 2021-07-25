package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ10815 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numberCards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numberCards.add(scanner.nextInt());
        }

        Collections.sort(numberCards);

        int m = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int number = scanner.nextInt();
            if (Collections.binarySearch(numberCards, number) >= 0) {
                stringBuilder.append("1 ");
            } else {
                stringBuilder.append("0 ");
            }
        }
        System.out.println(stringBuilder);
    }
}