package ru.gb;

import java.util.ArrayList;
import java.util.HashMap;



/**
 * Реализуйте структуру телефонной книги с помощью HashMap, 
 * учитывая, что один человек может иметь несколько телефонов.
 */
public class App 
{
    public static void main( String[] args ) {

        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        
        ArrayList<String> phoneSet1 = new ArrayList<>();
        phoneSet1.add("основной +79260587896");
        phoneSet1.add("рабочий +79271287996");
        phoneSet1.add("интернет +79161187896");
        phoneBook.putIfAbsent("Иванов Иван Иванович", phoneSet1);

        ArrayList<String> phoneSet2 = new ArrayList<>();
        phoneSet2.add("основной +79250127896");
        phoneSet2.add("рабочий +79260587626");
        phoneSet2.add("рабочий2 +79165447896");
        phoneSet2.add("интернет +79151587896");
        phoneBook.putIfAbsent("Петров Петр Петрович", phoneSet2);
        
        ArrayList<String> phoneSet3 = new ArrayList<>();
        phoneSet3.add("основной +79250587889");
        phoneSet3.add("рабочий +79150587887");
        phoneSet3.add("интернет +79260554566");
        phoneBook.putIfAbsent("Шувалов Иван Петрович", phoneSet3);
        
        System.out.println("Вывод всей телефонной книги: ");
        for (HashMap.Entry<String, ArrayList<String>> item : phoneBook.entrySet()) {
            Object[] temp = item.getValue().toArray();
            for (Object phone : temp) {
                System.out.printf("Абонент %s телефон %s \n", item.getKey(), phone);
            }
        }
        
        System.out.println("Вывод данных Петрова: ");
        for (HashMap.Entry<String, ArrayList<String>> subscriber : phoneBook.entrySet()) {
            if (subscriber.getKey().equals("Петров Петр Петрович")) {
                Object[] temp = subscriber.getValue().toArray();
                for (Object phone : temp) {
                    System.out.printf("Абонент %s телефон %s \n", subscriber.getKey(), phone);
                }
            }
        }
    }
}



