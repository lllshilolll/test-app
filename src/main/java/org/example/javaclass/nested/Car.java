package org.example.javaclass.nested;

import lombok.Data;
import lombok.ToString;

import static org.example.javaclass.nested.Car.StatisticOfCar.countCar;

@Data
public class Car {
    private static int prStOuterVar;
    private String name;
    private Wheel wheel;
    private MotorType motorType;

    {
        wheel = new Wheel();
    }

    public Car(String name, MotorType motorType) {
        this.name = name + StatisticOfCar.uniqueId++;
        this.motorType = motorType;
        countCar++;
    }

    //внутренний нестатический класс - доступ в рамках внешнего класса
    private class Motor {
        private int id;

        public Motor(int id) {
            this.id = id;
        }

        private void startMotor() {
            //внутренний класс в методе - доступ только в рамках метода
            class Oil {
                private void checkOil() {
                    System.out.println("Car " + name + " : motor " + id + " check oil");
                }
            }
            Oil oil = new Oil();
            oil.checkOil();
            System.out.println("Car " + name + " : motor " + id + " start");
        }
    }

    //внутренний нестатический класс - доступ в рамках внешнего класса
    class Wheel {
        private void checkWheel() {
            System.out.println("Car " + name + " : wheel work");
        }
    }

    //внутренний статический класс - не имеет доступ к нестатическим объектам,
    //логически не связан с внешним классом
    public static class StatisticOfCar {
        public static int countCar = 0;
        public static int uniqueId = 0;

    }

    public void createCar() {
        Motor motor = new Motor(motorType.getId());
        motor.startMotor();
        wheel.checkWheel();
    }

    public void deleteCar() {
        countCar--;
        System.out.println("Car " + name + " : deleted");
    }

}
