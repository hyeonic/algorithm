package me.hyeonic.algorithm.old.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon2217 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine()); // 로프의 개수
        Integer[] ropes = new Integer[n]; // 각 로프들이 버틸 수 있는 중량 모음

        for (int i = 0; i < ropes.length; i++) {
            ropes[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(ropes, Collections.reverseOrder()); // 내림차순 정렬

        int max = 0;
        for (int i = 0; i < ropes.length; i++) {
            if (max < ropes[i] * (i + 1)) { // 이전 최대값 보다 로프를 늘렸을 때 최대값이 더 크면
                max = ropes[i] * (i + 1);
            }
        }

        bufferedWriter.write(String.valueOf(max));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
