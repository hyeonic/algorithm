package me.hyeonic.algorithm.baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n + m; i++) {
            String name = bufferedReader.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 2) {
                result.add(key);
            }
        }

        result.sort(null);

        System.out.println(result.size());
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : result) {
            stringBuilder.append(name).append("\n");
        }
        System.out.println(stringBuilder);
    }
}