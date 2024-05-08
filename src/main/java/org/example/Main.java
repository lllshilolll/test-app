package org.example;

import org.example.javaclass.nested.Car;
import org.example.javaclass.nested.MotorType;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("car", MotorType.NORMAL);
        car.createCar();
        Car car2 = new Car("car", MotorType.BEST);
        car2.createCar();
        Car car3 = new Car("car", MotorType.BED);
        car3.createCar();
        car3.deleteCar();
        System.out.println("StatisticOfCar: Count car now: "+ Car.StatisticOfCar.countCar);
    }
}
