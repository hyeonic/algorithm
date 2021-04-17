package me.hyeonic.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon17219 {
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.valueOf(input[0]); // 저장된 사이트 주소
        int m = Integer.valueOf(input[1]); // 비밀번호를 찾으려는 사이트 주소의 수

        Map<String, String> sites = new HashMap<>();

        for (int i = 0; i < n; i++) {
            input = bufferedReader.readLine().split(" ");
            sites.put(input[0], input[1]);
        }

        for (int i = 0; i < m; i++) {
            String site = bufferedReader.readLine();
            bufferedWriter.write(sites.get(site) + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}