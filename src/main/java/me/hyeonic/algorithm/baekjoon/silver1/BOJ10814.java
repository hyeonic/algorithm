package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ10814 {

    static class User {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.age + " " + this.name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<User> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            users.add(new User(scanner.nextInt(), scanner.next()));
        }

        users.sort(Comparator.comparingInt(x -> x.age));

        users.forEach(System.out::println);
    }
}