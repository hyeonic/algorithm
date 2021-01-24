package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;
import java.util.Stack;

public class Baekjoon4949 {

    private static boolean isBalance(String words) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            }
        }

        if (stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String words = bufferedReader.readLine();
            if (words.equals(".")) break;
            if (isBalance(words)) bufferedWriter.write("yes\n");
            else bufferedWriter.write("no\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}