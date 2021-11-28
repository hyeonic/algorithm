package me.hyeonic.algorithm.programmers;

public class P43163 {

    static boolean[] visited;
    static int result;

    public int solution(String begin, String target, String[] words) {
        result = Integer.MAX_VALUE;
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private void dfs(String begin, String target, String[] words, int count) {

        if (begin.equals(target)) {
            result = Math.min(result, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int temp = 0;
                for (int j = 0; j < begin.length(); j++) {
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        temp++;
                    }

                    if (temp == begin.length() - 1) {
                        visited[i] = true;
                        dfs(words[i], target, words, count + 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        P43163 p43163 = new P43163();
        System.out.println(p43163.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(p43163.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}