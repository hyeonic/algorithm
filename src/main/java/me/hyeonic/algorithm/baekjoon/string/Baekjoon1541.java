package me.hyeonic.algorithm.baekjoon.string;

import java.io.*;

public class Baekjoon1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] expression = bufferedReader.readLine().split("-");

        int result = 0;
        int tempResult = 0;
        for (int i = 0; i < expression.length; i++) {
            String[] tempExpression = expression[i].split("\\+");

            for (int j = 0; j < tempExpression.length; j++) {
                tempResult += Integer.parseInt(tempExpression[j]);
            }

            if (i == 0) result += tempResult;
            else result -= tempResult;

            tempResult = 0;
        }

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

// 55-50+40-20+25-10
// 55+50-40+20-25+10
// 55-50+40