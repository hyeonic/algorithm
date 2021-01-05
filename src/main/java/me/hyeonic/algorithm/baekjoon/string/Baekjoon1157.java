package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon1157 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bufferedReader.readLine().toUpperCase(); // 대소문자 구분 x
        Map<Character, Integer> characterMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (characterMap.containsKey(character))
                characterMap.put(character, characterMap.get(character) + 1);
            else
                characterMap.put(character, 1);
        }

        int max = 0;
        Character resultKey = null;
        for (Character key : characterMap.keySet()) { // 가장 자주 언급된 key 와 언급 횟수를 저장
            if (max < characterMap.get(key)) {
                max = characterMap.get(key);
                resultKey = key;
            }
        }

        int count = 0;
        for (Character key : characterMap.keySet()) { // 중복되는 횟수를 count
            if (characterMap.get(key) == max) ++count;
        }

        if (count == 1) bufferedWriter.write(resultKey); // 언급된 횟수가 1번이면 가장 많이 언급되었다.
        else bufferedWriter.write('?'); // 1번 이상이면 ? 출력

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
