package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.Scanner;

public class BOJ11662 {

    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double ax = scanner.nextDouble();
        double ay = scanner.nextDouble();

        double bx = scanner.nextDouble();
        double by = scanner.nextDouble();

        double cx = scanner.nextDouble();
        double cy = scanner.nextDouble();

        double dx = scanner.nextDouble();
        double dy = scanner.nextDouble();

        int interval = 1_000_000;

        double mx = (bx - ax) / interval;
        double my = (by - ay) / interval;

        double kx = (dx - cx) / interval;
        double ky = (dy - cy) / interval;

        double min = getDistance(ax, ay, cx, cy);

        for (int i = 1; i <= interval; i++) {
            double temp = getDistance(ax + mx * i, ay + my * i, cx + kx * i, cy + ky * i);
            min = Math.min(min, temp);
        }

        System.out.println(min);
    }
}