package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ1427 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.next();
        List<Integer> list = new ArrayList<>();

        for (String s : number.split("")) {
            list.add(Integer.valueOf(s));
        }

        list.sort(Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);

        System.out.println(stringBuilder);
    }
}