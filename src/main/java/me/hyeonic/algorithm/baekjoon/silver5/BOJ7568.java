package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ7568 {

    static class Person {
        private int weight;
        private int height;
        private int rank;

        public Person(int weight, int height, int rank) {
            this.weight = weight;
            this.height = height;
            this.rank = rank;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split(" ");
            persons.add(new Person(Integer.valueOf(personInfo[0]), Integer.valueOf(personInfo[1]), 1));
        }

        for (Person personA : persons) {
            for (Person personB : persons) {
                if (!personA.equals(personB)) {
                    if (personA.height < personB.height && personA.weight < personB.weight) {
                        personA.rank++;
                    }
                }
            }
        }

        persons.forEach(person -> System.out.print(person.rank + " "));
    }
}