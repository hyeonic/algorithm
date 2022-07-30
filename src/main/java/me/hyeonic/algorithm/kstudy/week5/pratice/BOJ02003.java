package me.hyeonic.algorithm.kstudy.week5.pratice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ02003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        int count = 0; // 경우의 수 체크
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < numbers.size()) {
            if (sum >= m) {
                sum -= numbers.get(start);
                start++;
            }

            if (sum < m) {
                sum += numbers.get(end);
                end++;
            }

            if (sum == m) {
                count++;
            }
        }

        System.out.println(count);
    }
}
