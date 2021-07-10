package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon2577 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[10]; // 0 ~ 9가 나온 횟수를 저장하는 int 배열

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        String number = String.valueOf(a * b * c);

        for (int i = 0; i < number.length(); i++) {
           ++numbers[Character.getNumericValue(number.charAt(i))];
        }

        for (int i : numbers) {
            bufferedWriter.write(i + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Baekjoon2577_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Integer> numberMap = new HashMap<>();

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        String stringNumber = String.valueOf(a * b * c);

        for (int i = 0; i < stringNumber.length(); i++) {
            char charNum = stringNumber.charAt(i);
            if (numberMap.containsKey(charNum)) {
                numberMap.put(charNum, numberMap.get(charNum) + 1);
            } else {
                numberMap.put(charNum, 1);
            }
        }

        for (int i = 0; i < 10; i++) {
            char charNum = Character.forDigit(i, 10);
            if (numberMap.containsKey(charNum)) {
                bufferedWriter.write(numberMap.get(charNum) + "\n");
            } else {
                bufferedWriter.write("0\n");
            }
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}