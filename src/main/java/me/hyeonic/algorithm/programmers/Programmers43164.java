package me.hyeonic.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Programmers43164 {

    static boolean[] visited;
    static List<String> answers;

    public static String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(answers);
        return answers.get(0).split(" ");
    }

    private static void dfs(int count, String present, String answer, String[][] tickets) {
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

    private static List<String> compareList(List<String> result, List<String> list) {

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).compareTo(list.get(i)) < 0) {
                return list;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] tickets = new String[][]{
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        System.out.println(Arrays.toString(solution(tickets)));
        tickets = new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };

        System.out.println(Arrays.toString(solution(tickets)));
    }
}