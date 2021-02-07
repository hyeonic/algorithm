package me.hyeonic.algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon1373 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> binaryMap = new HashMap<>();
        binaryMap.put("000", "0");
        binaryMap.put("001", "1");
        binaryMap.put("010", "2");
        binaryMap.put("011", "3");
        binaryMap.put("100", "4");
        binaryMap.put("101", "5");
        binaryMap.put("110", "6");
        binaryMap.put("111", "7");

        String binary = bufferedReader.readLine();

        if (binary.length() % 3 == 1)
            binary = "00" + binary;
        else if (binary.length() % 3 == 2)
            binary = "0" + binary;


        for (int i = 0; i < binary.length() / 3; i++) {
            String divBinary = binary.substring(i * 3, i * 3 + 3);
            bufferedWriter.write(binaryMap.get(divBinary));
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}