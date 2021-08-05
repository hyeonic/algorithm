package me.hyeonic.algorithm.thisiscodingtest.chapter08;

import java.math.BigInteger;

public class Example8_4 {

    public static void main(String[] args) {

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        BigInteger[] dp = new BigInteger[100];

        // 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(1);

        // 피보나치 함수 반복문으로 구현 (바텀업 다이나믹 프로그래밍)
        for (int i = 3; i < 100; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        System.out.println(dp[99]);
    }
}