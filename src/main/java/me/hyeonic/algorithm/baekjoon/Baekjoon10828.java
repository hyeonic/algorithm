package me.hyeonic.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Baekjoon10828 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] commands = bufferedReader.readLine().split(" ");
            String command = commands[0];

            if (command.equals("push")) {
                deque.push(Integer.parseInt(commands[1]));
            } else if (command.equals("pop")) {
                if (deque.isEmpty()) bufferedWriter.write("-1\n");
                else bufferedWriter.write(deque.pop() + "\n");
            } else if (command.equals("size")) {
                bufferedWriter.write(deque.size() + "\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) bufferedWriter.write("1\n");
                else bufferedWriter.write("0\n");
            } else if (command.equals("top")) {
                if (deque.isEmpty()) bufferedWriter.write("-1\n");
                else bufferedWriter.write(deque.peek() + "\n");
            }
         }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}