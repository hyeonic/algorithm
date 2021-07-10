package me.hyeonic.algorithm.old.programmers;

public class Programmers43105 {

    private static int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height][height];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < height; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < height; i++) {
            max = Math.max(dp[height - 1][i], max);
        }

        return max;
    }

    public static void main(String[] args) {

        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        System.out.println(solution(triangle));
    }
}