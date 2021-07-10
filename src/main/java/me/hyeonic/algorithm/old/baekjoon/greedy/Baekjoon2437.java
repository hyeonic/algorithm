package me.hyeonic.algorithm.old.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon2437 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        List<Integer> weights = new ArrayList<>();

        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            weights.add(Integer.parseInt(input[i]));
        }

        Collections.sort(weights);

        int min = 1;
        for (int i = 0; i < n; i++) {
            if (min < weights.get(i)) break;
            min += weights.get(i);
            System.out.println("min = " + min);
        }

        System.out.println(min);

        bufferedReader.close();
    }
}