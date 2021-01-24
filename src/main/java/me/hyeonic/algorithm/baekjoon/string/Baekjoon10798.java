package me.hyeonic.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon10798 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, String> map = new HashMap<>();

        for (int n = 0; n < 5; n++) {
            String input = bufferedReader.readLine();
            for (int i = 0; i < input.length(); i++) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + input.charAt(i));
                } else {
                    map.put(i, Character.toString(input.charAt(i)));
                }
            }
        }

        for (Integer integer : map.keySet()) {
            bufferedWriter.write(map.get(integer));
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
