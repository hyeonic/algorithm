package me.hyeonic.algorithm.programmers;

public class P86051 {

    public int solution(int[] numbers) {

        int number = 45;
        for (int i : numbers) {
            number -= i;
        }

        return number;
    }

    public static void main(String[] args) {
        P86051 p86051 = new P86051();

        System.out.println(p86051.solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(p86051.solution(new int[]{5,8,4,0,6,7,9}));
    }
}