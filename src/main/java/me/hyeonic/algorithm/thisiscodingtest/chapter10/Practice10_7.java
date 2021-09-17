package me.hyeonic.algorithm.thisiscodingtest.chapter10;

import java.util.Scanner;

public class Practice10_7 {

    // 노드의 개수(N)와 연산의 개수(M)
    // 노드의 개수는 최대 100,000개라고 가정
    private static int n, m;
    // 부모 테이블 초기화
    private static int[] parent = new int[100_001];

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

        n = scanner.nextInt();
        m = scanner.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int operation = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // 합집합(Union) 연산인 경우
            if (operation == 0) {
                union(a, b);
            // 찾기(Find) 연산인 경우
            } else if (operation == 1) {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

/*
입력
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

출력
NO
NO
YES
 */