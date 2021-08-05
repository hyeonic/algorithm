package me.hyeonic.algorithm.thisiscodingtest.chapter08;

public class Example8_2 {

    // 한 번 계산된 결과를 메모이제이션하기 위한 배열 초기화
    static long[] dp = new long[100];

    // 피보나치 함수 재귀로 구현 (탑다운 다이나믹 프로그래밍)
    private static long fibonacci(int x) {

        // 종료 조건(1 혹은 2일 때 1을 반환)
        if (x == 1 || x == 2) {
            return 1;
        }

        // 이미 계산한 적이 있는 문제라면 그대로 반환
        if (dp[x] != 0) {
            return dp[x];
        }

        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        dp[x] = fibonacci(x - 1) + fibonacci(x - 2);
        return dp[x];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(50));
    }
}