package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;

public class Baekjoon11720 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] numbers = bufferedReader.readLine().split("");

        int result = 0;

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Baekjoon11720_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        String number = bufferedReader.readLine();

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Character.getNumericValue(number.charAt(i));
        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Main {
    public static void main(String[] args) {
        int a = (int)'1';
        int b = Character.getNumericValue('1');

        System.out.println(a);
        System.out.println(b);
    }
}