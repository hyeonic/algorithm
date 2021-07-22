package me.hyeonic.algorithm.thisiscodingtest.chapter06;

import java.util.ArrayList;
import java.util.List;

public class Example6_9 {

    static class Fruit {
        private String name;
        private int score;

        public Fruit(String name, int score) {
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
        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        fruits.sort((x, y) -> {
            if (x.score < y.score) {
                return -1;
            }
            return 1;
        });

        fruits.stream().forEach(fruit -> System.out.print("(" + fruit.getName() + ", " + fruit.getScore() + ") "));
    }
}