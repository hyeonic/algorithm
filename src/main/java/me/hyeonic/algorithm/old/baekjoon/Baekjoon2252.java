package me.hyeonic.algorithm.old.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon2252 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<Integer>[] lists = new LinkedList[n + 1]; // 노드의 연결 상태를 저장
        int[] edges = new int[n + 1]; // 간선의 개수 저장

        for (int i = 1; i <= n; i++) lists[i] = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            input = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            lists[a].add(b);
            edges[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (edges[i] == 0) queue.offer(i);

        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            stringBuilder.append(now + " ");

            for (Integer index : lists[now]) {
                edges[index]--;
                if (edges[index] == 0) queue.offer(index);
            }
        }

        System.out.println(stringBuilder.toString());
        bufferedReader.close();
    }
}