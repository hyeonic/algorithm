package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ11651 {

    static class Location {
        int x; int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            locations.add(new Location(x, y));
        }

        locations.sort((a, b) -> {
            if (a.y < b.y) {
                return -1;
            } else if (a.y == b.y && a.x < b.x) {
                return -1;
            } else if (a.y == b.y && a.x == b.x) {
                return 0;
            }
            return 1;
        });

        locations.forEach(location -> System.out.println(location.x + " " + location.y));
    }
}