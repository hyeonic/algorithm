package me.hyeonic.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon10546 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        Map<String, Integer> runners = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String runner = bufferedReader.readLine();
            runners.put(runner, runners.getOrDefault(runner, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String runner = bufferedReader.readLine(); // 완주한 사람
            runners.put(runner, runners.get(runner) - 1);
        }

        for (String key : runners.keySet()) {
            if (runners.get(key) == 1) System.out.println(key);
        }

        bufferedReader.close();
    }
}