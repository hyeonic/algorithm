package me.hyeonic.algorithm.thisiscodingtest.chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Example10_5 {

    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    // 노드의 개수는 최대 100,000개 라고 가정
    private static int v, e;
    private static int[] parent = new int[100_001]; // 부모 테이블 초기화하기

    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    private static List<Edge> edges = new ArrayList<>();
    private static int result = 0;

    private static class Edge {
        private int distance;
        private int nodeA;
        private int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public int getDistance() {
            return distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }
    }

    // 특정 원소가 속한 집합을 찾기
    private static int findParent(int x) {

        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        v = scanner.nextInt();
        e = scanner.nextInt();

        // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int cost = scanner.nextInt();

            edges.add(new Edge(cost, a, b));
        }

        // 간선을 비용 오름차순으로 정렬
        Collections.sort(edges, (o1, o2) -> {
            if (o1.getDistance() < o2.getDistance()) {
                return -1;
            }
            return 1;
        });

        // 간선을 하나씩 확인하며
        for (Edge edge : edges) {
            int cost = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println(result);
    }
}

/*
입력
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25

출력
159
 */