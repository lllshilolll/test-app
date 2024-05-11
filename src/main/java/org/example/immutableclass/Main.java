package org.example.immutableclass;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "first book");

        ImmutableClass immutableClass = new ImmutableClass(hashMap);
        immutableClass.getBookTable().put(2, "second book"); // не поменяет

        hashMap.put(3, "third book");// не поменяет

        System.out.println(immutableClass.getBookTable());
    }
}
