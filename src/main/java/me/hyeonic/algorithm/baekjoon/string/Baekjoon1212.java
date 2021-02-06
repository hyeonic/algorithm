package me.hyeonic.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon1212 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> octalMap = new HashMap<>();
        octalMap.put("0", "000");
        octalMap.put("1", "001");
        octalMap.put("2", "010");
        octalMap.put("3", "011");
        octalMap.put("4", "100");
        octalMap.put("5", "101");
        octalMap.put("6", "110");
        octalMap.put("7", "111");

        String octal = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < octal.length(); i++)
            stringBuilder.append(octalMap.get(String.valueOf(octal.charAt(i))));

        for (int i = 0; i < 2; i++) {
            if (stringBuilder.toString().charAt(0) == '0')
                stringBuilder.deleteCharAt(0);
        }


        System.out.println(stringBuilder.toString());

        bufferedReader.close();
    }
}