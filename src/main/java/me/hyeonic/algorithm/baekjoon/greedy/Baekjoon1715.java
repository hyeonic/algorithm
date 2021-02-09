package me.hyeonic.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            queue.add(num);
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            if (queue.size() == 1) break;
            int num1 = queue.poll();
            int num2 = queue.poll();
            queue.add(num1 + num2);
            sum += num1 + num2;
        }

        System.out.println(sum);
        bufferedReader.close();
    }
}

/**
 요구사항
  - 정렬된 두 묶음의 숫자 카드가 있다고 한다.
 각 묶음의 카드의 수를 A, B라 하면 보통 두 묶음을 합쳐서 하나로 만드는 데에는 A+B 번의 비교를 해야 한다.
  - N개의 숫자 카드 묶음의 각각의 크기가 주어질 때,최소한 몇 번의 비교가 필요한지를 구한다.

 입력
  - 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100,000) 이어서 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다.
 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다.

 출력
  - 첫째 줄에 최소 비교 횟수를 출력한다.
 */