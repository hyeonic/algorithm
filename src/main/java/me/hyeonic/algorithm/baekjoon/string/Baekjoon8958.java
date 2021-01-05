package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;

public class Baekjoon8958 {

    public static boolean isCorrect(char c) {
        if (c == 'O') return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] submits = new String[n]; // 제출된 답을 저장하는 String 배열

        for (int i = 0; i < n; i++) {
            submits[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < submits.length; i++) {
            int score = 0; // 시험 점수
            int tempScore = 0; // 연속해서 맞았을 경우 점수를 축적하는 임시 점수
            if (isCorrect(submits[i].charAt(0))) {
                ++tempScore;
                score += tempScore;
            }
            for (int j = 1; j < submits[i].length(); j++) {
                if (isCorrect(submits[i].charAt(j))) {
                    ++tempScore;
                    score += tempScore;
                } else {
                    tempScore = 0;
                }
            }
            bufferedWriter.write(score + "\n");
        }


        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
