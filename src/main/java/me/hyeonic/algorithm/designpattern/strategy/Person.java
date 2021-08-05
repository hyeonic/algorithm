package me.hyeonic.algorithm.designpattern.strategy;

public class Person {

    void runContext(PublicTransportation publicTransportation) {
        publicTransportation.ride();
    }
}