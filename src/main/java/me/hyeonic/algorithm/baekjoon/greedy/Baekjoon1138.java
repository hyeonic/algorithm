package me.hyeonic.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1138 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] inputSplit = bufferedReader.readLine().split(" ");
        List<Integer> heights = new ArrayList<>();

        System.out.println("----------");

        for (int i = n; i >= 1; i--) {
            int heightNo = Integer.parseInt(String.valueOf(inputSplit[i - 1]));
            heights.add(heightNo, i);
            for (Integer height : heights) {
                System.out.print(height + " ");
            }
            System.out.println();
        }

        for (Integer height : heights) {
            bufferedWriter.write(height + " ");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Baekjoon1138_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] inputSplit = bufferedReader.readLine().split(" ");
        int[] heights = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int leftNo = Integer.parseInt(inputSplit[i - 1]);
            for (int j = 1; j <= n; j++) {
                if (leftNo == 0 && heights[j] == 0) {
                    heights[j] = i;
                    break;
                } else if (heights[j] == 0) {
                    --leftNo;
                }
            }
        }

        for (int i = 1; i < heights.length; i++) {
            bufferedWriter.write(heights[i] + " ");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

//https://dundung.tistory.com/76
//https://youngest-programming.tistory.com/432