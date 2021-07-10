package me.hyeonic.algorithm.old.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10815 {

    static int[] array;

    private static int binarySearch(int start, int end, int check) {

        int mid = (start + end) / 2;

        if (mid >= end) return 0;

        if (array[mid] == check) return 1;
        else if (array[mid] < check)
            return binarySearch(mid + 1, end, check);
        else
            return binarySearch(start, mid, check);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        array = new int[n];

        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(input[i]);
        Arrays.sort(array);

        int m = Integer.parseInt(bufferedReader.readLine());

        input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int check = Integer.parseInt(input[i]);
            System.out.print(binarySearch(0, n, check) + " ");
        }

        bufferedReader.close();
    }
}

class Baekjoon10815_1 {

    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        array = new int[n];

        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(input[i]);
        Arrays.sort(array);

        int m = Integer.parseInt(bufferedReader.readLine());

        input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int check = Integer.parseInt(input[i]);
            int index = Arrays.binarySearch(array, check);

            if(index < 0) System.out.print("0 ");
            else System.out.print("1 ");
        }

        bufferedReader.close();
    }
}