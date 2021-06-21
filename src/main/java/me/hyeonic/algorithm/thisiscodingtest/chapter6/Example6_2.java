package me.hyeonic.algorithm.thisiscodingtest.chapter6;

public class Example6_2 {

    public static void main(String[] args) {
        int[] array = {3, 5};
        swap(array, 0, 1);

        System.out.println(array[0] + " | " + array[1]);
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}