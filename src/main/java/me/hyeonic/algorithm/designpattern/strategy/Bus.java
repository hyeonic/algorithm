package me.hyeonic.algorithm.designpattern.strategy;

public class Bus implements PublicTransportation {

    @Override
    public void ride() {
        System.out.println("버스를 타다.");
    }
}