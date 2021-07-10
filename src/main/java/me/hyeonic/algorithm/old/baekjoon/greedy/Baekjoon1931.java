package me.hyeonic.algorithm.old.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine()); // 회의의 수

        int[][] conferences = new int[n][2];

        for (int i = 0; i < conferences.length; i++) {
            String[] time = bufferedReader.readLine().split(" ");
            conferences[i][0] = Integer.parseInt(time[0]); // 회의 시작 시간
            conferences[i][1] = Integer.parseInt(time[1]); // 회의 끝나는 시간
        }

//        Arrays.sort(conferences, (x, y) -> {
//            return Integer.compare(x[0], y[0]);
//        });
//        Arrays.sort(conferences, (x, y) -> {
//            return Integer.compare(x[1], y[1]);
//        });

        Arrays.sort(conferences, Comparator.comparingInt(x -> x[0]));
        Arrays.sort(conferences, Comparator.comparingInt(x -> x[1]));

        int end = conferences[0][1];
        int count = 1;
        for (int i = 1; i < conferences.length; i++) {
            if (end <= conferences[i][0]) { // 이전 회의 끝나는 시간이 현재 회의 시작 시간보다 작거나 같으면
                end = conferences[i][1];
                ++count;
            }
        }

        bufferedWriter.write(String.valueOf(count));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}