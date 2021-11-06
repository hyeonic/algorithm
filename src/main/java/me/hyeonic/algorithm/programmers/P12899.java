package me.hyeonic.algorithm.programmers;

public class P12899 {

    public String solution(int n) {

        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            int remainder = n % 3;
            n = n / 3;

            if (remainder == 0) {
                stringBuilder.append("4");
                n--;
            } else if (remainder == 1) {
                stringBuilder.append("1");
            } else if (remainder == 2) {
                stringBuilder.append("2");
            }
        }

        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        P12899 p12899 = new P12899();

        System.out.println(p12899.solution(1));
        System.out.println(p12899.solution(2));
        System.out.println(p12899.solution(3));
        System.out.println(p12899.solution(4));
        System.out.println(p12899.solution(6));
        System.out.println(p12899.solution(9));
        System.out.println(p12899.solution(15));
        System.out.println(p12899.solution(500_000_000));
    }
}