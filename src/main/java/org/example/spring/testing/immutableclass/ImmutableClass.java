package org.example.spring.testing.immutableclass;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//final - не дает наследовать и менять класс
public final class ImmutableClass {

    //все переменные - private
    private final HashMap<Integer, String> bookTable;

    //копирование в новую переменную - не дает поменять исходный объект
    public ImmutableClass(HashMap<Integer, String> bookTable) {
        Set<Map.Entry<Integer, String>> entries = bookTable.entrySet();
        this.bookTable = (HashMap<Integer, String>) entries.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    //копирование в новую переменную в getter - не дает поменять исходный объект
    public HashMap<Integer, String> getBookTable() {
        Set<Map.Entry<Integer, String>> entries = bookTable.entrySet();
        return (HashMap<Integer, String>) entries.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    //отсутствие setters - значение присваивается только в конструкторе
}
