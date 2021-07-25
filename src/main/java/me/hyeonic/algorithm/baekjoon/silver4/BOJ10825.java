package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ10825 {

    static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(new Student(
                    scanner.next(),
                    scanner.nextInt(),
                    scanner.nextInt(),
                    scanner.nextInt()));
        }

        students.sort((x, y) -> {
            if (x.korean > y.korean) {
                return -1;
            } else if (x.korean == y.korean && x.english < y.english) {
                return -1;
            } else if (x.korean == y.korean && x.english == y.english && x.math > y.math) {
                return -1;
            } else if (x.korean == y.korean && x.english == y.english && x.math == y.math) {
                return x.name.compareTo(y.name);
            }
            return 1;
        });

        students.forEach(student -> System.out.println(student.name));
    }
}