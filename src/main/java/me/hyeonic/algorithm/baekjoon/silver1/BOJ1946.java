package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ1946 {

    private static class Employee {
        private final int a; // 1차 서류심사
        private final int b; // 2차 면접시험

        public Employee(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int employeeCount = scanner.nextInt();

            List<Employee> employees = new ArrayList<>();
            for (int i = 0; i < employeeCount; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                employees.add(new Employee(a, b));
            }

            employees.sort(Comparator.comparingInt(employee -> employee.a));

            int count = 1;
            Employee standard = employees.get(0);
            for (int i = 1; i < employeeCount; i++) {
                if (standard.b > employees.get(i).b) {
                    count++;
                    standard = employees.get(i);
                }
            }

            System.out.println(count);
        }
    }
}