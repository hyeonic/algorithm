package me.hyeonic.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P42577 {

    public boolean solution(String[] phoneBook) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for (String key : phoneBook) {
            for (int j = 0; j < key.length(); j++) {
                if (map.containsKey(key.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solution2(String[] phoneBook) {

        HashSet<String> set = new HashSet<>(Arrays.asList(phoneBook));

        for (String e : phoneBook) {
            for (int j = 0; j < e.length(); j++) {
                if (set.contains(e.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P42577 p425577 = new P42577();

        System.out.println(p425577.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(p425577.solution(new String[]{"123","456","789"}));
        System.out.println(p425577.solution(new String[]{"12","123","1235","567","88"}));
    }
}