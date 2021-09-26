package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1446 {

    private static List<Path> paths = new ArrayList<>();
    private static int[] dist = new int[10_001];

    private static class Path {
        private final int start;
        private final int end;
        private final int distance;

        public Path(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 지름길의 개수
        int d = scanner.nextInt(); // 고속도로의 길이

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int distance = scanner.nextInt();

            if (end > d) { // 역주행 판단
                continue;
            }

            if (end - start <= distance) { // 지름길이 아니라고 판단
                continue;
            }

            paths.add(new Path(start, end, distance));
        }

        for (int i = 1; i <= d; i++) {
            dist[i] = dist[i - 1] + 1;

            for (Path path : paths) {
                if (path.end == i) {
                    dist[i] = Math.min(dist[i], dist[path.start] + path.distance);
                }
            }
        }

        System.out.println(dist[d]);
    }
}