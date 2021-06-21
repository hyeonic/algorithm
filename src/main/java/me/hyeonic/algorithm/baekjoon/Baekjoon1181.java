package me.hyeonic.algorithm.baekjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Baekjoon1181 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Set<String> words = new HashSet<>();

        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        words = words.stream()
                .sorted((a, b) -> {
                    if (a.length() > b.length()) {
                        return 1;
                    } else if (a.length() == b.length()) {
                        return a.compareTo(b);
                    }
                    return -1;
                })
                .collect(Collectors.toCollection(() -> new LinkedHashSet<>()));

        for (String word : words) {
            System.out.println(word);
        }
    }
}

class Baekjoon1181_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        words.sort((a, b) -> {
            if (a.length() > b.length()) {
                return 1;
            } else if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return -1;
        });

        String prev = "";
        for (String word : words) {
            if (prev.equals(word)) continue;
            System.out.println(word);
            prev = word;
        }
    }
}