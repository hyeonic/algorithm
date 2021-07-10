package me.hyeonic.algorithm.old.programmers.level2.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers42583 {

    public static int solution(int bridgeLength, int weight, int[] truckWeights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        int sumWeight = 0;
        for (int truckWeight : truckWeights) {
            while (true) {
                if (queue.isEmpty()) { // queue 가 비어있는 경우
                    queue.add(truckWeight); // 무조건 queue 에 삽입
                    sumWeight += truckWeight; // 다리에 있는 트럭 무게 합산
                    ++answer; // 경과 시간 더하기
                    break;
                } else if (queue.size() == bridgeLength) { // queue 가 가득찬 경우
                    sumWeight -= queue.poll();
                } else {
                    if (sumWeight + truckWeight > weight) { // 다리 위 트럭의 무게 합이 버틸 수 있는 무게 보다 크다면
                        ++answer;
                        queue.add(0);
                    } else {
                        queue.add(truckWeight);
                        sumWeight += truckWeight;
                        ++answer;
                        break;
                    }
                }
            }
        }

        return answer + bridgeLength;
    }

    public static void main(String[] args) {

        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));

    }
}