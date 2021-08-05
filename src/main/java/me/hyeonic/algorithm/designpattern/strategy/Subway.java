package me.hyeonic.algorithm.designpattern.strategy;

public class Subway implements PublicTransportation {

    @Override
    public void ride() {
        System.out.println("지하철을 타다.");
    }
}