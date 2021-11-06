package me.hyeonic.algorithm.programmers;

public class P42883 {

    public String solution(String number, int k) {

        if (number.charAt(0) == '0') {
            return "0";
        }

        int index = 0;
        char max;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number.length() - k; i++) {
            max = '0';
            for (int j = index; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    index = j + 1;
                }
            }
            stringBuilder.append(max);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        P42883 p42883 = new P42883();

        System.out.println(p42883.solution("1924", 0));
        System.out.println(p42883.solution("1924", 2));
        System.out.println(p42883.solution("1924", 4));
        System.out.println(p42883.solution("1231234", 3));
        System.out.println(p42883.solution("4177252841", 4));
    }
}