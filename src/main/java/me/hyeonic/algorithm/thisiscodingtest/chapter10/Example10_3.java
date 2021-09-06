package me.hyeonic.algorithm.thisiscodingtest.chapter10;

import java.util.Scanner;

public class Example10_3 {

    // 노드의 개수 (V)와 간선(Union 연산)의 개수(E)
    // 노드의 개수는 최대 100,000개라고 가정
    private static int v, e;
    private static int[] parent = new int[100_001]; // 부모 테이블 초기화

    // 특정 원소가 속한 집합을 찾기
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

        // Union 연산을 각각 수행
        for (int i =0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            unionParent(a, b);
        }

        // 각 원소가 속한 집합 출력하기
        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}

/*
입력
6 4
1 4
2 3
2 4
5 6

출력
각 원소가 속한 집합: 1 1 1 1 5 5
부모 테이블: 1 1 2 1 5 5
 */