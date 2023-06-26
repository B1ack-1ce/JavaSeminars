package HomeWorks.HomeWork_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Hw_05 {
    static Scanner iScanner = new Scanner(System.in);
     public static void main(String[] args) {
        HashMap<String, ArrayList<String>> contacts = new HashMap<>();

        boolean flag = true;
        while (flag) {
            System.out.println("1 - Добавить контакт");
            System.out.println("2 - Показать контакты");
            System.out.println("3 - Выйти из программы");
            
            String input = prompt("Номер операции:");
            switch (input) {
                case "1" -> createContact(contacts);
                case "2" -> printAllContacts(contacts);
                case "3" -> flag = false;
                default -> System.out.println("Некорректный ввод");
            }
        }
    }

    private static String prompt(String msg){
        System.out.println(msg);
        return iScanner.nextLine();
    }

    private static void createContact(HashMap<String, ArrayList<String>> contacts) {
        String name = prompt("Введите имя:");
        String phone = prompt("Введите телефон:");

        if (contacts.containsKey(name)) {
            ArrayList<String> phones = contacts.get(name);
            
            if (!phones.contains(phone)) phones.add(phone);
        } 
        else {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            contacts.put(name, phones);
        }
    }

    private static void printAllContacts(HashMap<String, ArrayList<String>> contacts) {
        String[] keys = contacts.keySet().toArray(new String[0]);
        
        Arrays.sort(keys, (o1, o2) -> contacts.get(o2).size() - contacts.get(o1).size());

        for (String key : keys) {
            System.out.println("\nИмя контакта:\n " + key + 
                               "\nНомера телефонов:\n" + String.join("\n", contacts.get(key)));
        }
    }
}
