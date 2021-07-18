package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ5430 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String commands = scanner.next();
            int n = scanner.nextInt();

            Deque<String> numbers = new LinkedList<>();
            String array = scanner.next();
            for (String number : array.substring(1, array.length() - 1).split(",")) {
                numbers.add(number);
            }

            if (n == 0 && commands.contains("D")) {
                System.out.println("error");
                continue;
            }

            boolean isError = false;
            boolean isReverse = false;
            for (int j = 0; j < commands.length(); j++) {
                char command = commands.charAt(j);
                if (command == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (numbers.size() == 0) {
                        isError = true;
                        break;
                    }

                    if (isReverse) {
                        numbers.removeLast();
                    } else {
                        numbers.removeFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder stringBuilder = new StringBuilder("[");
                while (!numbers.isEmpty()) {
                    stringBuilder.append((isReverse ? numbers.removeLast() : numbers.removeFirst()) + ",");
                }
                stringBuilder.append("]");
                String result = stringBuilder.toString().replace(",]", "]");
                System.out.println(result);
            }
        }
    }
}