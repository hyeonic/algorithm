package me.hyeonic.algorithm.programmers;

public class Programmers42895 {

    private static int n;
    private static int target;
    private static int answer = Integer.MAX_VALUE;

    public static int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);

        if (answer > 8) {
            return -1;
        } else {
            return answer;
        }
    }

    private static void dfs(int count, int prev) {
        if (prev == target) {
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
        for (int i = 0; i < 8 - count; i++) {
            int newCount = count + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }
}