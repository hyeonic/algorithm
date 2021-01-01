package me.hyeonic.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Baekjoon1399 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> alphabetMap = new HashMap<>(); // 각 단어당 가중치 값을 저장하는 map
        int n = Integer.parseInt(bufferedReader.readLine()); // 단어의 개수

        for (int i = 0; i < n; i++) {
            String string = bufferedReader.readLine(); // 단어 저장
            int length = string.length() - 1; // 각 단어 자리수

            for (int j = 0; j <= length; j++) {
                String alphabet = String.valueOf(string.charAt(j)); // 해당 자리수의 알파벳
                if (alphabetMap.containsKey(alphabet)) { // map 에 알파벳이 있다면
                    // 기존 값에 더해줌
                    alphabetMap.put(alphabet, alphabetMap.get(alphabet) + (int) Math.pow(10, length - j));
                } else { // map 에 알파벳이 없다면
                    // 새로운 값을 추가
                    alphabetMap.put(alphabet, (int) Math.pow(10, length - j));
                }
            }
        }

        List<String> keySetList = new ArrayList<>(alphabetMap.keySet()); // map 에 저장된 알파벳 집합 list
        Collections.sort(keySetList, (x, y) -> { // map 의 value 가 큰 순서로 list 의 key 값으로 정렬
            return alphabetMap.get(y).compareTo(alphabetMap.get(x));
        });

        int result = 0; // 결과값 저장하는 변수
        int weight = 9; // 9 ~ 0 까지의 가중치
        for (int i = 0; i < keySetList.size(); i++) {
            result += alphabetMap.get(keySetList.get(i)) * weight; // 큰 자리수 부터 가중치를 하나씩 내려가며 곱하고 더해줌
            --weight;
        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
