package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.*;
import java.util.Scanner;

public class Baekjoon11719 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }

        bufferedReader.close();
    }
}

class Baekjoon11719_scanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }
}