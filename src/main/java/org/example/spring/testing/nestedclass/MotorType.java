package org.example.spring.testing.nestedclass;

public enum MotorType {
    BED(0),
    NORMAL(1),
    BEST(2);

    private final int i;
    MotorType(int i) {
        this.i = i;
    }

    public int getId(){
        return i;
    }
}
