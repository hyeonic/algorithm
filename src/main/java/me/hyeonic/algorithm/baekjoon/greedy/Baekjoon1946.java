package me.hyeonic.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;

public class Baekjoon1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine()); // 테스트 케이스의 개수

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine()); // 지원자의 숫자

            int[][] grades = new int[n][2];
            for (int j = 0; j < n; j++) {
                String[] gradeSplit = bufferedReader.readLine().split(" ");
                grades[j][0] = Integer.parseInt(gradeSplit[0]); // 서류심사 순위
                grades[j][1] = Integer.parseInt(gradeSplit[1]); // 면접시험 순위
            }

            // 서류심사 순위에 대해서 오름차순으로 정렬
            Arrays.sort(grades, (x, y) -> {
                return Integer.compare(x[0], y[0]);
            });

            int count = 1; // 서류심사 순위 기준 1순위 합격자 1명 부터 시작
            int tempGrade = grades[0][1]; // 서류심사 순위 기준 1순위의 면접시험 순위를 tempGrade 에 저장
            for (int j = 1; j < grades.length; j++) {
                if (grades[j][1] < tempGrade) {
                    // 서류심사 순위를 정렬했기 때문에 더이상 고려대상이 아니다.
                    // if 현재 지원자의 면접시험 순위가 임시로 저장된 면접시험 순위보다 작으면
                    // 합격자 수가 늘어나고 해당 합격자의 면접시험 순위가 들어간다.
                    ++count;
                    tempGrade = grades[j][1];
                }
            }
            bufferedWriter.write(String.valueOf(count) + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}