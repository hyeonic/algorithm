package me.hyeonic.algorithm.thisiscodingtest.chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Practice10_8 {

    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    private static int v, e;
    // 부모 테이블 초기화
    private static int[] parent = new int[100_001];
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
    private static int find(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

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

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int cost = scanner.nextInt();

            // 비용순으로 정렬하기 위해 튜플의 첫 번째 원소를 비용으로 설정
            edges.add(new Edge(cost, a, b));
        }

        // 간선을 비용 오름차순으로 정렬. 마지막 value가 결국 비용 최대값
        Collections.sort(edges, (o1, o2) -> {
            if (o1.distance < o2.distance) {
                return -1;
            }
            return 1;
        });

        // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선
        int last = 0;

        // 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (find(a) != find(b)) {
                union(a, b);
                result += cost;
                last = cost; // 사이클이 발생하지 않을 때 가중치 오름차순이기 때문에 최신화
            }
        }

        System.out.println(result - last);
    }
}

/*
입력
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4

출력
8
 */