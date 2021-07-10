package me.hyeonic.algorithm.old.programmers.kakao.blind2020;

public class StringCompression_3 {

    static int compress(String s, int n) {
        int result = 0;
        String prev = s.substring(0, n);
        int count = 1;

        for (int i = n; i <= s.length() - n; i += n) {
            String tempString = s.substring(i, i + n);
            if (tempString.equals(prev)) ++count;
            else {
                if (count > 1) result += String.valueOf(count).length();
                result += n;
                prev = tempString;
                count = 1;
            }
        }

        if (count > 1) result += String.valueOf(count).length();
        result += n;
        result += s.length() % n;

        System.out.print("길이 : ");

        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcdede";

        for (int i = 1; i < s.length(); i++) {
            System.out.println(compress(s, i));
        }
    }
}
