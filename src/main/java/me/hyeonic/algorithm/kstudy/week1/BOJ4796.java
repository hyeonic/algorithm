package me.hyeonic.algorithm.kstudy.week1;

import java.util.Scanner;

public class BOJ4796 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        while (true) {
            int l = scanner.nextInt();
            int p = scanner.nextInt();
            int v = scanner.nextInt();

            if (l == 0 && p == 0 && v == 0) {
                return;
            }

            int day = ((v / p) * l) + Math.min(v % p, l);
            System.out.println("Case " + count + ": " + day);
            count++;
        }
    }
}
