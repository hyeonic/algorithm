package me.hyeonic.algorithm.programmers.kakao.blind2020;

public class StringCompression_solution {

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

        return result;
    }

    static int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length() / 2; i++) {
            int length = compress(s, i);
            if (length < min) min = length;
        }

        return min == Integer.MAX_VALUE ? s.length() : min;
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
            System.out.println(solution(s));
        }
    }
}
