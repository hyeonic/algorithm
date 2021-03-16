package me.hyeonic.algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon7568 {

    public static class Person {
        private int weight; // 몸무게
        private int height; // 키
        private int rank; // 등수

        public Person(int weight, int height, int rank) {
            this.weight = weight;
            this.height = height;
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            persons.add(new Person(weight, height, 1));
        }

        for (Person person1 : persons) {
            for (Person person2 : persons) {
                if (person1.equals(person2)) continue;
                else if (person1.weight < person2.weight && person1.height < person2.height) {
                    person1.rank += 1;
                }
            }
        }

        for (Person person : persons)
            System.out.print(person.rank + " ");

        bufferedReader.close();
    }
}