package me.hyeonic.algorithm.programmers;

public class Programmers43165 {


    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private static int dfs(int[] numbers, int target, int index, int prev) {
        if (index == numbers.length) {
            if (prev == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return dfs(numbers, target, index + 1, prev + numbers[index])
                + dfs(numbers, target, index + 1, prev - numbers[index]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}