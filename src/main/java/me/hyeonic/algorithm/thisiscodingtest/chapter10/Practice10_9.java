package me.hyeonic.algorithm.thisiscodingtest.chapter10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Practice10_9 {

    // 노드의 개수(V)
    private static int v;
    // 모든 노드에 대한 진입차수는 0으로 초기화
    private static int[] indegree = new int[50];
    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    private static List<List<Integer>> graph = new ArrayList<>();
    // 각 강의 시간을 0으로 초기화
    private static int[] times = new int[501];

    // 위상 정렬 함수
    private static void topologySort() {
        int[] result = new int[501]; // 알고리즘 수행 결과를 담을 배열
        for (int i = 1; i <= v; i++) {
            result[i] = times[i];
        }

        // 큐 라이브러리 사용
        Queue<Integer> queue = new LinkedList<>();

        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 원소 꺼내기
            int now = queue.poll();
            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] =
                        Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    queue.offer(graph.get(now).get(i));
                }
            }
        }

        // 위상 정렬을 수행한 결과 출력
        for (int i = 1; i <= v; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        v = scanner.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 방향 그래프의 모든 간선 정보를 입력받기
        for (int i = 1; i <= v; i++) {
            // 첫 번째 수는 시간 정보를 담고 있음
            int x = scanner.nextInt();
            times[i] = x;

            // 해당 강의를 듣기 위해 먼저 들어야 하는 강의들의 번호 입력
            while (true) {
                x = scanner.nextInt();
                if (x == -1) {
                    break;
                }

                indegree[i] += 1;
                graph.get(x).add(i);
            }
        }

        topologySort();
    }
}

/*
입력
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1

출력
10
20
14
18
17
 */