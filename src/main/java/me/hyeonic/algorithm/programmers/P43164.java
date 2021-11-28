package me.hyeonic.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P43164 {

    static boolean[] visited;
    static List<String> answers;

    public String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(answers);
        return answers.get(0).split(" ");
    }

    private void dfs(int count, String present, String answer, String[][] tickets) {
        if (count == tickets.length) {
            answers.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(present)) {
                visited[i] = true;
                dfs(count + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        P43164 p43164 = new P43164();
        System.out.println(
            Arrays.toString(p43164.solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
    }
}