package org.example.spring.testing.hashmap;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Programmer {
    private final String position;
    private final int salary;

    protected Programmer(String position, int salary) {
        this.position = position;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Programmer that = (Programmer) o;

        if (salary != that.salary) return false;
        return Objects.equals(position, that.position);
    }

    //Сперва производится сравнение по хешу, чтобы понять, совпадают ли объекты,
    //а только после подключается equals,
    //чтобы определить, совпадают ли значения полей объекта.
    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + salary;
        return result;

    }

}