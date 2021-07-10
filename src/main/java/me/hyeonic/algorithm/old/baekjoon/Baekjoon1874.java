package me.hyeonic.algorithm.old.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine()); // 1 부터 n 까지의 수
        int[] nums = new int[n]; // 출력 순서를 확인할 수 있는 array

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(bufferedReader.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i); // stack에 값을 채움
            stringBuilder.append("+\n");

            while (!stack.isEmpty() && stack.peek() == nums[index]) {
                stack.pop();
                index++;
                stringBuilder.append("-\n");
            }
        }

        if (!stack.isEmpty()) System.out.print("NO");
        else System.out.print(stringBuilder.toString());

        bufferedReader.close();
    }
}