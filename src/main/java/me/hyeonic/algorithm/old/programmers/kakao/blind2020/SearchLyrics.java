package me.hyeonic.algorithm.old.programmers.kakao.blind2020;

import java.util.Arrays;

public class SearchLyrics {

    static class Solution {
        public int[] solution(String[] words, String[] queries) {

            int[] answer = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                int count = 0;
                for (int j = 0; j < words.length; j++) {
                    if (queries[i].length() != words[j].length()) continue;
                    else {
                        boolean isMatch = true;
                        for (int k = 0; k < queries[i].length(); k++) {
                            if (queries[i].charAt(k) != '?' && queries[i].charAt(k) != words[j].charAt(k)) {
                                isMatch = false;
                                break;
                            }
                        }
                        if (isMatch) ++count;
                    }
                }
                answer[i] = count;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
        System.out.println(Arrays.toString(new Solution().solution(words, queries)));
    }
}
