package org.example.spring.testing.hashmap;


import java.util.*;

public class MapTest {
    public static void main(String[] args) {

        Programmer programmer1 = new Programmer("Junior", 300);
        Programmer programmer2 = new Programmer("Junior", 300);

        System.out.println(" * Programmer * ");
        System.out.println("programmer1_ identity hashCode:" + System.identityHashCode(programmer1)
                + "; object hashCode: " + programmer1.hashCode());
        System.out.println("programmer2_ identity hashCode:" + System.identityHashCode(programmer2)
                + "; object hashCode: " + programmer2.hashCode());

        System.out.println("\n* == or equals() *");
        //false
        System.out.println(programmer1 == programmer2);
        //true
        System.out.println(programmer1.equals(programmer2));

        //modifier native - для методов, которые реализованы на другом языке (f.e. Object.hashCode())
        HashMap<String, Programmer> hashMap = new HashMap<>();

        hashMap.put("1", programmer1);
        //так как hashcode равны, ключи равны - объект перезаписывается
        //если hashcode равны, но значения ключей не равны - объект записывается в эту же ячейку
        //(в LinkedList добавляется значение)
        hashMap.put("1", programmer2);

        hashMap.put("2", programmer2);


        //getClass().hashCode() - определяет hashCode класса, а не объекта
        //object.hashCode() - определяет hashCode экземпляра - меняется после добавления нового элемента
        //System.identityHashCode(o) - гарантированно не изменится в течение всего времени существования объекта
        //если hashCode() не переопределен = identityHashCode()
        System.out.println("\n* HASHMAP information *");
        System.out.println("hashMap_ hashCode class: " + hashMap.getClass().hashCode()
                + "; object hashCode: " + hashMap.hashCode()
                + "; identity hashCode: " + System.identityHashCode(hashMap)
        );

        System.out.println("\n* OBJECTS in hashmap information *");
        Set<Map.Entry<String, Programmer>> setEntry = hashMap.entrySet();
        for (Map.Entry<String, Programmer> s : setEntry) {
            System.out.println("key object hashCode: " + s.getKey().hashCode() + "; value object hashCode: " + s.getValue().hashCode());
            System.out.println("key identity hashCode: " + System.identityHashCode(s.getKey()) + "; value identity hashCode: " + System.identityHashCode(s.getValue()));
        }

    }
}
