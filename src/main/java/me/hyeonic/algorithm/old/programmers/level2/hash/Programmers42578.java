package me.hyeonic.algorithm.old.programmers.level2.hash;

import java.util.HashMap;
import java.util.Map;

public class Programmers42578 {

    public static int solution(String[][] clothes) {
        int count = 1;
        Map<String, Integer> clotheMap = new HashMap<>();

        for (String[] clothe : clothes)
            clotheMap.put(clothe[1], clotheMap.getOrDefault(clothe[1], 0) + 1); // key: 옷 종류 value: 개수

        for (String key : clotheMap.keySet())
            count *= clotheMap.get(key) + 1; // 안 입는 경우를 포함하기 위해서 +1

        return count - 1; // 모든 옷을 안 입는 경우는 없으므로 -1
    }

    public static void main(String[] args) {

        String[][][] clothesList = {
                {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}},
                {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}
        };

        for (int i = 0; i < clothesList.length; i++) {
            System.out.println(solution(clothesList[i]));
        }
    }
}