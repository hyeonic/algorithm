package me.hyeonic.algorithm.programmers.level1.hash;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Programmers42576 {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String s : participant) {
//            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
//            else map.put(s, 1);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion)
                map.put(s, map.get(s) - 1);

        for (String s : map.keySet()) {
            if (map.get(s) == 1) answer = s;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        String[][] participants = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };

        String[][] completions = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };

        for (int i = 0; i < participants.length; i++)
            System.out.println(solution(participants[i], completions[i]));

    }
}