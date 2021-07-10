package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.*;

public class Baekjoon9012 {

    static boolean isCorrectParenthesis(String parenthesis) {
        int count = 0;
        for (char c : parenthesis.toCharArray()) {
            if (c == '(') ++count;
            else if (c == ')') --count;

            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String parenthesis = bufferedReader.readLine();
            if (isCorrectParenthesis(parenthesis)) bufferedWriter.write("YES\n");
            else bufferedWriter.write("NO\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}