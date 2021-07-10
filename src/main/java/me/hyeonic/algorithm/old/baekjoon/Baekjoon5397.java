package me.hyeonic.algorithm.old.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Baekjoon5397 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String password = bufferedReader.readLine();
            Deque<Character> pre = new LinkedList<>();
            Deque<Character> post = new LinkedList<>();

            for (int j = 0; j < password.length(); j++) {
                char c = password.charAt(j);
                if (c == '<') {
                    if (!pre.isEmpty()) post.push(pre.pop());
                } else if (c == '>') {
                    if (!post.isEmpty()) pre.push(post.pop());
                } else if (c == '-') {
                    if (!pre.isEmpty()) pre.pop();
                } else {
                    pre.push(c);
                }
            }

            while (!post.isEmpty()) {
                pre.push(post.pop());
            }

            while (!pre.isEmpty()) {
                bufferedWriter.write(pre.pollLast());
            }

            bufferedWriter.write("\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}