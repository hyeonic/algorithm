package me.hyeonic.algorithm.thisiscodingtest.chapter10;

import java.util.Scanner;

public class Example10_4 {

    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    private static int v, e;
    private static int[] parent = new int[100_001]; // 부모 테이블 초기화하기

    // 특정 원소가 속한 집합을 차기
    private static int findParent(int x) {

        // 루트 노드가 아니라면, 루트 노드를 찾을 때 까지 재귀적으로 호출
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

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        boolean cycle = false; // 사이클 발생 여부

        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // 사이클이 발생한 경우 종료
            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            // 사이클이 발생하지 않았다면 합집합(Union) 연산 수행
            } else {
                unionParent(a, b);
            }
        }

        if (cycle) {
            System.out.println("사이클이 발생했습니다.");
        } else {
            System.out.println("사이클이 발생하지 않았습니다.");
        }
    }
}