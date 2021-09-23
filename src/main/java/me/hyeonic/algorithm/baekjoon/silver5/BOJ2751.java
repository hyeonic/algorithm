package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2751 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        numbers.sort(null); // == Collections.sort(numbers) -> 내부적으로 같다. list.sort(null)로 처리된다.
//        numbers.sort(Comparator.naturalOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            stringBuilder.append(number).append("\n");
        }
        System.out.println(stringBuilder);
    }
}

class BOJ2751Counting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        boolean[] array = new boolean[2_000_001];

        for (int i = 0; i < n; i++) {
            array[scanner.nextInt() + 1_000_000] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                stringBuilder.append(i - 1_000_000).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}