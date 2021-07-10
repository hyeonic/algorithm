package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = bufferedReader.readLine();
        List<Integer> list = new ArrayList<>();

        int total = 0;
        for (int i = 0; i < number.length(); i++) {
            total += number.charAt(i) - '0';
            list.add(number.charAt(i) - '0');
        }

        Collections.sort(list);

        if (list.contains(0) && total % 3 == 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                bufferedWriter.write(String.valueOf(list.get(i)));
            }
        } else bufferedWriter.write("-1");

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}