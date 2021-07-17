package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2941 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> alphabets = new ArrayList<>();
        alphabets.add("c=");
        alphabets.add("c-");
        alphabets.add("dz=");
        alphabets.add("d-");
        alphabets.add("lj");
        alphabets.add("nj");
        alphabets.add("s=");
        alphabets.add("z=");

        String word = scanner.nextLine();

        for (String alphabet : alphabets) {
            word = word.replaceAll(alphabet, " ");
        }

        System.out.println(word.length());
    }
}