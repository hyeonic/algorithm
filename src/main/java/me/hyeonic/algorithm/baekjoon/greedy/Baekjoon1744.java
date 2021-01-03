package me.hyeonic.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon1744 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            numbers[i] = number;
        }

        Arrays.sort(numbers);

        List<Integer> minusList = new ArrayList<>(); // 0을 포함한 음수를 저장할 list
        List<Integer> plusList = new ArrayList<>(); // 1을 제외한 양수를 저장할 list

        int result = 0;
        for (int number : numbers) {
            if (number <= 0) minusList.add(number);
            else if (number == 1) result += 1; // 1인 경우 더할 때 가장 값이 커진다.
            else plusList.add(number);
        }

        for (int i = 0; i < minusList.size(); i+=2) {
            if (i == minusList.size() - 1) result += minusList.get(i);
            else result += minusList.get(i) * minusList.get(i + 1);
        }

        for (int i = plusList.size() - 1; i >= 0; i-=2) {
            if (i == 0) result += plusList.get(i);
            else result += plusList.get(i) * plusList.get(i - 1);
        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
