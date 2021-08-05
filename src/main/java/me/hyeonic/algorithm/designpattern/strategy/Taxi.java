package me.hyeonic.algorithm.designpattern.strategy;

public class Taxi implements PublicTransportation {

    @Override
    public void ride() {
        System.out.println("택시를 타다.");
    }
}