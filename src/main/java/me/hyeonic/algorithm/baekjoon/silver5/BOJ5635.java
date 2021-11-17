package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ5635 {

    private static class Person {
        private String name;
        private String birth;

        public Person(String name, String birth) {
            this.name = name;
            this.birth = birth;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", birth='" + birth + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            String day = scanner.next();
            String month = scanner.next();
            String year = scanner.next();

            if (day.length() == 1) {
                day = "0" + day;
            }

            if (month.length() == 1) {
                month = "0" + month;
            }

            String birth = year + month + day;

            Person person = new Person(name, birth);
            persons.add(person);
        }

        persons.sort(Comparator.comparing(o -> o.birth));

        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println(persons.get(persons.size() - 1).name);
        System.out.println(persons.get(0).name);
    }
}