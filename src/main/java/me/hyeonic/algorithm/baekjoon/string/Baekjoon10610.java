package me.hyeonic.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = bufferedReader.readLine();
        List<Integer> list = new ArrayList<>();

        int total = 0;
        for (int i = 0; i < number.length(); i++) {
            total += number.charAt(i) - '0';
            list.add(number.charAt(i) - '0');
        }

        Collections.sort(list);

        if (list.contains(0) && total % 3 == 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                bufferedWriter.write(String.valueOf(list.get(i)));
            }
        } else bufferedWriter.write("-1");

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 요구사항
  - 양수 N이 주어진다.
  - 양수 N에 포함되어 있는 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만든다.

 입력
  N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.

 출력
  미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.
 */