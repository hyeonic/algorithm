package me.hyeonic.algorithm.old.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon4796 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int l = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        int index = 1;
        while (l != 0 && p != 0 && v != 0) {
            int temp = (v / p) * l;

            if (v - (v / p) * p <= l) temp += v - (v / p) * p;
            else temp += l;

            bufferedWriter.write("Case " + index + ": " + temp + "\n");

            input = bufferedReader.readLine().split(" ");
            l = Integer.parseInt(input[0]);
            p = Integer.parseInt(input[1]);
            v = Integer.parseInt(input[2]);
            ++index;
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 요구사항
  - 캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있다
  - 강산이는 이제 막 28일 휴가를 시작했다.
  - 캠핑장을 연속하는 P일 중, L일 동안만 사용할 수 있다. 강산이는 이제 막 V일 짜리 휴가를 시작했다.
 강상이가 캠핑장을 최대 며칠동안 사용할 수 있는지 구한다. (1 < ㅣ < P < V)

 입력
  - 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 각 테스트 케이스는 한 줄로 이루어져 있고, L, P, V를 순서대로 포함하고 있다.
 모든 입력 정수는 int범위이다. 마지막 줄에는 0이 3개 주어진다.

 출력
  - 각 테스트 케이스에 대해서, 강산이가 캠핑장을 최대 며칠동안 사용할 수 있는지 예제 출력처럼 출력한다.
 */