package me.hyeonic.algorithm.programmers;

public class P12977 {

    public int solution(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P12977 p12977 = new P12977();

        System.out.println(p12977.solution(new int[]{1, 2, 3, 4}));
        System.out.println(p12977.solution(new int[]{1, 2, 7, 6, 4}));
    }
}