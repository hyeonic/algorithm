package me.hyeonic.algorithm.swexpertacademy;

import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String non = "CEFGHIJKLMNSTUVWXYZ";
        String one = "ADOPQR";

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String a = scanner.next();
            String b = scanner.next();

            for (char c : a.toCharArray()) {
                if (non.contains(String.valueOf(c))) {
                    a = a.replace(String.valueOf(c), "0");
                } else if (one.contains(String.valueOf(c))) {
                    a = a.replace(String.valueOf(c), "1");
                }
            }

            for (char c : b.toCharArray()) {
                if (non.contains(String.valueOf(c))) {
                    b = b.replace(String.valueOf(c), "0");
                } else if (one.contains(String.valueOf(c))) {
                    b = b.replace(String.valueOf(c), "1");
                }
            }

            if (a.equals(b)) {
                System.out.println("#" + (i + 1) + " SAME");
            } else {
                System.out.println("#" + (i + 1) + " DIFF");
            }
        }
    }
}