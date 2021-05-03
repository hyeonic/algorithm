package me.hyeonic.algorithm.thisiscodingtest.chapter5;

public class Example5_3 {

    public static void recursiveFunction() {
        System.out.println("재귀 함수를 호출합니다.");
        recursiveFunction();
    }

    public static void main(String[] args) {
        recursiveFunction();
    }
}