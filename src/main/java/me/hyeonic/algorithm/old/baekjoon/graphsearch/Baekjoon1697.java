package me.hyeonic.algorithm.old.baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1697<unsigned> {

    static int n;
    static int k;
    static int[] visited = new int[100001];

    public static int bfs(int n) {

        if (n == k) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;

        while(!queue.isEmpty()) {
            int position = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = 0;
                
                if (i == 0) {
                    next = position - 1;
                } else if (i == 1) {
                    next = position + 1;
                } else if (i == 2) {
                    next = 2 * position;
                }

                if (next == k) return visited[position];

                if (isPostiontion(next)) {
                    queue.add(next);
                    visited[next] = visited[position] + 1;
                }
            }
        }
        return 0;
    }

    public static boolean isPostiontion(int position) {
        if (position >= 0 && position < visited.length && visited[position] == 0) {
            return true;
        } else return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        bufferedWriter.write(String.valueOf(bfs(n)));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
 요구사항
  - 수빈이는 점 N에 있다. 0 <= N <= 100,000
  - 동생은 점 K에 있다. 0 <= K <= 100,000
  - 수빈이의 위치가 X일 때 X - 1, x + 1, 2 * X로 이동할 수 있다.
  - 수빈이가 동생을 찾을 수 있는 가장 빠른 시간을 출력한다.
*/