package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11866 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }

            list.add(queue.poll());
        }

        StringBuilder stringBuilder = new StringBuilder("<");
        for (Integer value : list) {
            stringBuilder.append(value).append(", ");
        }
        stringBuilder.append(">");

        System.out.println(stringBuilder.toString().replace(", >", ">"));
    }
}