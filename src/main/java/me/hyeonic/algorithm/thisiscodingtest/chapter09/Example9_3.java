package me.hyeonic.algorithm.thisiscodingtest.chapter09;

import java.util.Arrays;
import java.util.Scanner;

public class Example9_3 {

    private static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M)
    // 노드으 개수는 최대 500개 라고 가정
    private static int n, m;
    // 2차원 배열(그래프 표현)을 만들기
    private static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A에서 B로 가는 비용은 C라고 설정
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, INF 라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INF\t");
                } else {
                    // 도달할 수 있는 경우 거리를 출력
                    System.out.print(graph[a][b] + "\t");
                }
            }
            System.out.println();
        }
    }
}

/*
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
*/