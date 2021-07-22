package me.hyeonic.algorithm.thisiscodingtest.chapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice6_11 {

    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            students.add(new Student(name, score));
        }

        students.sort((x, y) -> {
            if (x.score < y.score) {
                return -1;
            }
            return 1;
        });

        students.forEach(value -> System.out.print(value.getName() + " "));
    }
}

/*
입력
2
홍길동 95
이순신 77

출력
이순신 홍길동
*/