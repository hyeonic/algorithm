package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baekjoon1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 듣도 못한 사람의 수
        int m = Integer.parseInt(input[1]); // 보도 못한 사람의 수

        Set<String> personSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            personSet.add(bufferedReader.readLine());
        }

        for (int i = 0; i < m; i++) {
            String person = bufferedReader.readLine();
            if (personSet.contains(person)) {
                result.add(person);
            }
        }

        Collections.sort(result);
        bufferedWriter.write(result.size() + "\n");
        for (String s : result) {
            bufferedWriter.write(s + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}