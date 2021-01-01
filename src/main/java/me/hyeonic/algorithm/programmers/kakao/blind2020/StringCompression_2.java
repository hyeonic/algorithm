package me.hyeonic.algorithm.programmers.kakao.blind2020;

public class StringCompression_2 {

    static int compress(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        String prev = s.substring(0, n);
        int count = 1;

        for (int i = n; i <= s.length() - n; i += n) {
            String tempString = s.substring(i, i + n);
            if (tempString.equals(prev)) ++count;
            else {
                if (count > 1) stringBuilder.append(count);
                stringBuilder.append(prev);
                prev = tempString;
                count = 1;
            }
        }

        if (count > 1) stringBuilder.append(count);
        stringBuilder.append(prev);
        int tail = s.length() % n;
        if (tail > 0) stringBuilder.append(s.substring(s.length() - tail));

        System.out.print("압축된 문자열 : " + stringBuilder.toString() + " 길이 : ");

        return stringBuilder.length();
    }

    public static void main(String[] args) {
        String s = "abcabcdede";

        for (int i = 1; i < s.length(); i++) {
            System.out.println(compress(s, i));
        }
    }
}
