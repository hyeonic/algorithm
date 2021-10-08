package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ18870 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] copyNums = nums.clone(); // 깊은 복사
        Arrays.sort(copyNums); // 오름차순 정렬

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : copyNums) {
            if (!map.containsKey(num)) {
                map.put(num, count++);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(map.get(num)).append(" ");
        }
        System.out.println(stringBuilder);
    }
}