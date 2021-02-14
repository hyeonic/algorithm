package me.hyeonic.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 포켓몬의 개수
        int m = Integer.parseInt(input[1]); // 맞춰야 하는 문제의 개수

        Map<Integer, String> pokedex1 = new HashMap<>(); // 포켓몬 도감을 저장하는 map
        Map<String, Integer> pokedex2 = new HashMap<>(); // 포켓몬 도감을 저장하는 map

        for (int i = 1; i <= n; i++) {
            String pokemon = bufferedReader.readLine();
            pokedex1.put(i, pokemon);
            pokedex2.put(pokemon, i);
        }


        for (int i = 0; i < m; i++) {
            String question = bufferedReader.readLine();
            if (question.matches("-?\\d+"))
                bufferedWriter.write(pokedex1.get(Integer.parseInt(question)) + "\n");
            else
                bufferedWriter.write(pokedex2.get(question) + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
