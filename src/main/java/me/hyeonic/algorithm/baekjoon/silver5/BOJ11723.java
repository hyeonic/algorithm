package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.HashSet;
import java.util.Scanner;

// TODO: 비트 마스크 방법 풀어보기
public class BOJ11723 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();
        int m = scanner.nextInt();

        HashSet<Integer> set = new HashSet<>();

        while (m-- > 0) {
            String command = scanner.next();
            if (command.equals("all")) {
                for(int i = 1; i <= 20; i++){
                    set.add(i);
                }
                continue;
            } else if (command.equals("empty")) {
                set.clear();
                continue;
            }

            int number = scanner.nextInt();
            if (command.equals("add")) {
                set.add(number);
            } else if (command.equals("remove")) {
                set.remove(number);
            } else if (command.equals("check")) {
                if(set.contains(number)) {
                    stringBuilder.append("1\n");
                } else {
                    stringBuilder.append("0\n");
                }
            } else if (command.equals("toggle")) {
                if(set.contains(number)) {
                    set.remove(number);
                } else {
                    set.add(number);
                }
            }
        }

        System.out.println(stringBuilder);
    }
}