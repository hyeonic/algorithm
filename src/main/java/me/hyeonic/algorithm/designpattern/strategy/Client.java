package me.hyeonic.algorithm.designpattern.strategy;

public class Client {

    public static void main(String[] args) {
        Person person = new Person();

        person.runContext(new Bus());
        person.runContext(new Subway());
        person.runContext(new Taxi());
    }
}