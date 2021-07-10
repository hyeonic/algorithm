package me.hyeonic.algorithm.old.programmers.level2.sort;

import java.util.Arrays;

public class Programmers42746 {

    public static String solution(int[] numbers) {

        String[] stringNumbers = new String[numbers.length];
        for (int i = 0; i < stringNumbers.length; i++)
            stringNumbers[i] = String.valueOf(numbers[i]);

        Arrays.sort(stringNumbers, (x, y) -> (y + x).compareTo(x + y));

        return stringNumbers[0].equals("0") ? "0" : String.join("", stringNumbers);
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution(new int[]{0, 0, 0, 0}));
    }
}