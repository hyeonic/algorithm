package me.hyeonic.algorithm.programmers;

import java.util.HashSet;

public class P42839 {

    public int solution(String numbers) {

        HashSet<Integer> hashSet = new HashSet<>();

        permutation("", numbers, hashSet);

        int count = 0;
        for (Integer value : hashSet) {
            if (value == 2) {
                count++;
            } else if (value % 2 != 0 && isPrime(value)) {
                count++;
            }
        }

        return count;
    }

    private void permutation(String number, String numbers, HashSet<Integer> set) {

        if (!number.equals("")) {
            set.add(Integer.parseInt(number));
        }

        for (int i = 0; i < numbers.length(); i++) {
            permutation(number + numbers.charAt(i),
                    numbers.substring(0, i) + numbers.substring(i + 1),
                    set);
        }
    }

    private boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i += i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P42839 p42839 = new P42839();

        System.out.println(p42839.solution("17"));

        System.out.println();

        System.out.println(p42839.solution("011"));
    }
}