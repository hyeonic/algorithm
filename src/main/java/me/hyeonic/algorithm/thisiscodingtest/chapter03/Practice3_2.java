package me.hyeonic.algorithm.thisiscodingtest.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class Practice3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums); // 입력 받은 수 정렬

        int first = nums[n - 1];
        int second = nums[n - 2];

        int count = (m / (k + 1)) * k;
        count += m % (k + 1);

        int result = 0;
        result += count * first;
        result += (m - count) * second;

        System.out.println(result);
    }
}

/*
input
5 8 3
2 4 5 4 6

output
46
*/