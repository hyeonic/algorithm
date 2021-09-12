package me.hyeonic.algorithm.thisiscodingtest.chapter10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Example10_6 {

    // 노드의 개수 (V)와 간선의 개수 (E)
    // 노드의 개수는 최대 100,000개라고 가정
    private static int v, e;
    // 모든 노드에 대한 진입차수는 0으로 초기화
    private static int[] indegree = new int[100_001];
    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기회
    private static List<List<Integer>> graph = new ArrayList<>();

    // 위상 정렬 메소드
    private static void topologySort() {
        List<Integer> result = new ArrayList<>(); // 알고리즘 수행 결과를 담을 리스트
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
            result.add(now);
            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    queue.offer(graph.get(now).get(i));
                }
            }
        }

        // 위상 정렬을 수행한 결과 출력
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        v = scanner.nextInt();
        e = scanner.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 방향 그래프의 모든 간선 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b); // 정점 A에서 B로 이동 가능
            // 진입 차수를 1 증가
            indegree[b]++;
        }

        topologySort();
    }
}

/*
입력
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4

출력
1 2 5 3 6 4 7
 */