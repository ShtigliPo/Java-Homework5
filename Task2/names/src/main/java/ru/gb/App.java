package ru.gb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Пусть дан список сотрудников: Иван, Пётр, Антон и так далее.
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности.
 */
public class App 
{
    public static void main( String[] args ) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Алексей");
        names.add("Григорий");
        names.add("Сергей");
        names.add("Евгений");
        names.add("Алексей");
        names.add("Григорий");
        names.add("Сергей");
        names.add("Евгений");
        names.add("Алексей");
        names.add("Сергей");
        names.add("Григорий");
        names.add("Алексей");
        names.add("Алексей");
        names.add("Сергей");
        names.add("Григорий");
        names.add("Алексей");
        names.add("Григорий");

        System.out.printf( "Список имеет %d имён\n", names.size());
        for (String person : names) {
            System.out.println(person);
        }

        Map<String, Integer> hashMap = new HashMap<>();
        for (String person : names) {
            String name = person;
            Integer frequency = hashMap.get(name);
            hashMap.put(name, frequency == null ? 1 : frequency + 1); 
        }
        System.out.println(hashMap);

        ArrayList<Map.Entry<String, Integer>> mappings = new ArrayList<>(hashMap.entrySet());
        Collections.sort(mappings, Comparator.comparing (Map.Entry :: getValue));
        Collections.reverse(mappings);
        Map<String, Integer> linkedHashMapSort = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : mappings) {
            linkedHashMapSort.put(entry.getKey(), entry.getValue());
        }
        System.out.println(linkedHashMapSort);
    }
}

