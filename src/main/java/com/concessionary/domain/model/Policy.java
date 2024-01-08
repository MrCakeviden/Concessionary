package com.concessionary.domain.model;


public class Policy
{
    private Car car;
    private CarOwner carOwner;
    private Coverage coverage;

    public Policy(Car car, CarOwner carOwner, Coverage coverage) {
        this.car = car;
        this.carOwner = carOwner;
        this.coverage = coverage;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }

}
