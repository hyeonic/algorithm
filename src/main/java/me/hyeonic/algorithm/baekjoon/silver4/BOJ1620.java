package me.hyeonic.algorithm.baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<Integer, String> nameBook = new HashMap<>();
        Map<String, Integer> indexBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = bufferedReader.readLine();
            nameBook.put(i + 1, name);
            indexBook.put(name, i + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String problem = bufferedReader.readLine();
            if (problem.matches("-?\\d+")) {
                stringBuilder.append(nameBook.get(Integer.parseInt(problem))).append("\n");
            } else {
                stringBuilder.append(indexBook.get(problem)).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}