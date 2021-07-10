package me.hyeonic.algorithm.old.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] cards = new int[n];
        int[] result = new int[20_000_001];

        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(input[i]);
            result[cards[i] + 10_000_000] += 1;
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        input = bufferedReader.readLine().split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int searchNum = Integer.parseInt(input[i]);
            stringBuilder.append(result[searchNum + 10_000_000] + " ");
        }

        System.out.println(stringBuilder.toString());
        bufferedReader.close();
    }
}

class Baekjoon10816_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> countMap = new HashMap<>();

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] cards = new int[n];

        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(input[i]);
            if (countMap.containsKey(cards[i]))
                countMap.put(cards[i], countMap.get(cards[i]) + 1);
            else
                countMap.put(cards[i], 1);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        int[] searchList = new int[m];
        input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            searchList[i] = Integer.parseInt(input[i]);
            if (countMap.containsKey(searchList[i]))
                bufferedWriter.write(countMap.get(searchList[i]) + " ");
            else
                bufferedWriter.write("0 ");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}