package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon2941 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> croatiaAlphabetList = new ArrayList<>();

        croatiaAlphabetList.add("c=");
        croatiaAlphabetList.add("c-");
        croatiaAlphabetList.add("dz=");
        croatiaAlphabetList.add("d-");
        croatiaAlphabetList.add("lj");
        croatiaAlphabetList.add("nj");
        croatiaAlphabetList.add("s=");
        croatiaAlphabetList.add("z=");

        String word = bufferedReader.readLine();

        for (String croatiaAlphabet : croatiaAlphabetList) {
            if (word.contains(croatiaAlphabet))
                word = word.replaceAll(croatiaAlphabet, " ");
        }

        bufferedWriter.write(String.valueOf(word.length()));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}