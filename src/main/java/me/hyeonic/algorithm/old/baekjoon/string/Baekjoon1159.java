package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon1159 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        Map<Character, Integer> squad = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String player = bufferedReader.readLine();
            Character playerC = player.charAt(0);
            if (squad.containsKey(playerC))
                squad.put(playerC, squad.get(player.charAt(0)) + 1);
            else
                squad.put(playerC, 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character player : squad.keySet()) {
            if (squad.get(player) >= 5)
                stringBuilder.append(player);
        }

        if (stringBuilder.toString().equals(""))
            System.out.println("PREDAJA");
         else
            System.out.println(stringBuilder.toString());

        bufferedReader.close();
    }
}