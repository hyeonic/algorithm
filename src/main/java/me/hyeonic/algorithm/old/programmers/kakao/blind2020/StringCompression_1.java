package me.hyeonic.algorithm.old.programmers.kakao.blind2020;

public class StringCompression_1 {

    static int compress(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) ++count;
            else {
                if (count > 1) stringBuilder.append(count);
                stringBuilder.append(prev);
                prev = s.charAt(i);
                count = 1;
            }
        }

        if (count > 1) stringBuilder.append(count);
        stringBuilder.append(prev);

        System.out.print("압축된 문자열 : " + stringBuilder.toString() + " 길이 : ");

        return stringBuilder.length();
    }

    public static void main(String[] args) {
        String[] inputs = {
                "aabbaccc",
                "ababcdcdababcdcd",
                "abcabcdede",
                "abcabcabcabcdededededede",
                "xababcdcdababcdcd",
                "xxxxxxxxxxyyy",
                "a"
        };

        for (String s : inputs) {
            System.out.println(compress(s));
        }
    }
}
