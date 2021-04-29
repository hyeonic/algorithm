package me.hyeonic.algorithm.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon6603 {

    private static int[] array;
    private static boolean[] visited;
    static int k;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            k = scanner.nextInt();

            if (k == 0) {
                break;
            }

            array = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                array[i] = scanner.nextInt();
            }

            dfs(0, 0);
            System.out.println();
        }
        scanner.close();
    }

    private static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < k; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
