package me.hyeonic.algorithm.baekjoon.gold4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1707 {

    private static List<List<Integer>> graph;
    private static int[] team;
    private static boolean isParticiple;

    private static final int RED = 1;

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        team[v] = RED;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            // 인접 노드 탐색
            for (Integer i : graph.get(node)) {
                // 이전 팀과 같은 경우
                if (team[node] == team[i]) {
                    isParticiple = false;
                    return;
                }

                if (team[i] == 0) {
                    team[i] = team[node] * -1;
                    queue.add(i);
                }
            }
        }
    }

    private static void dfs(int v, int color) {
        team[v] = color;

        for (Integer i : graph.get(v)) {
            if (team[v] == team[i]) {
                isParticiple = false;
                return;
            }

            if (team[i] == 0) {
                dfs(i, color * -1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int v = scanner.nextInt();
            int e = scanner.nextInt();

            graph = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            team = new int[v + 1];
            isParticiple = true;
            for (int i = 1; i <= v; i++) {
                if (team[i] == 0) {
//                    bfs(i);
                    dfs(i, RED);
                    if (!isParticiple) {
                        break;
                    }
                }
            }

            if (isParticiple) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}