package me.hyeonic.algorithm.programmers.kakao.blind2020;

public class StringCompression {

    static int solution(String s) {
        int answer = 0;

        int minLength = Integer.MAX_VALUE;

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length() / 2; i++) { // 반절까지 비교가 가능하기 때문에 0 ~ 길이의 반까지 반복
            String prev = s.substring(0, i);
//            System.out.println("1 - 압축할 문자열의 길이 : " + i);
            int count = 1;
            String tempString = "";
            for (int j = i; j <= s.length() - i; j += i) {
                String current = s.substring(j, j + i);
//                System.out.println("2 - 비교할 문자열의 길이 : " + i + " 문자열 : " + current);
                if (prev.equals(current)) {
                    ++count;
                } else if (count != 1) {
                    tempString = tempString + count + prev;
                    count = 1;
                } else {
                    tempString = tempString + prev;
                }
                prev = current;
//                System.out.println("중간과정 -> " + tempString);
            }

            prev = s.substring(s.length() - i - (s.length() % i));
            if (count != 1) {
                tempString = tempString + count + prev;
            } else if (count == 1)
//                System.out.println(s.length() - i - (s.length() % i) + ", " + s.substring(s.length() - i - (s.length() % i)));
                tempString = tempString + prev;

//            System.out.println("바뀐 문자열 : " + tempString + " 문자열 길이 : " + tempString.length());
            if (minLength > tempString.length()) minLength = tempString.length();
        }

        answer = minLength;

        return answer;
    }

    public static void main(String[] args) {
        String[] inputs = {
//                "aabbaccc",
//                "ababcdcdababcdcd",
//                "abcabcdede",
//                "abcabcabcabcdededededede",
//                "xababcdcdababcdcd",
//                "xxxxxxxxxxyyy",
//                "a",
//                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
//                "zxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxz"
        };

        for (String s : inputs) {
            System.out.println(solution(s));
        }
    }
}
