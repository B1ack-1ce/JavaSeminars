package HomeWorks.HomeWork_04;

import java.util.Scanner;

public class Hw_04 {
    private static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[][] users = new String[16][]; // изначально создается массив на 16 элементов
        Boolean flag = true;
        int index = 0;
        while(flag){
            if(index == users.length - 1) users = expandArray(users);
            
            System.out.println("Введите номер операции: ");
            System.out.println("1 - создать нового пользователя ");
            System.out.println("2 - вывести пользователей в консоль ");
            System.out.println("3 - отсортировать пользователей по возрасту ");
            System.out.println("4 - выход из приложения ");
            String input = iScanner.nextLine();
            
            switch(input){
                case "1":
                    users[index] = createNewUser();
                    index++;
                    System.out.println("\nНовый пользователь добавлен\n");
                    break;
                case "2":
                    System.out.println("\nСписок пользователей: \n");
                    printUsers(users);
                    break;
                case "3":
                    sortUsers(users);
                    System.out.println("\nПользователи отсортированны по возрасту\n");
                    break;
                case "4":
                    flag = false;
                    System.out.println("Выходим...");
                    break;
                default:
                    System.out.println("Неверная операция");
            }
        }
        
    }
    //Сортировка массива по возрасту
    private static void sortUsers(String[][] users){
        for (int i = 0; i < users.length; i++) {
            if(users[i] == null) continue;
            for (int j = i; j < users.length; j++) {
                if(users[j] == null) continue;
                String[] tempUser = null;
                if(Integer.parseInt(users[j][3]) < Integer.parseInt(users[i][3])){
                    tempUser = users[i];
                    users[i] = users[j];
                    users[j] = tempUser;
                }
            }
        }
    }
    //Создание нового пользователя
    private static String[] createNewUser(){
        String[] user = new String[5];
        for (int i = 0, count = 1; i < user.length; i++, count++) {
            switch(count){
                case 1:
                    user[i] = prompt("Введите фамилию: ");
                    break;
                case 2:
                    user[i] = prompt("Введите имя: ");
                    break;
                case 3:
                    user[i] = prompt("Введите отчество: ");
                    break;
                case 4:
                    user[i] = prompt("Введите возраст: ");
                    break;
                case 5:
                    user[i] = prompt("Введите пол: ");
                    break;
            }
        }
        return user;
    }
    
    private static String prompt(String msg){
        System.out.println(msg);
        String word = iScanner.nextLine();
        return word;
    }
    //Вывод всех пользователей в консоль
    private static void printUsers(String[][] users){
        for (int i = 0; i < users.length; i++) {
            if(users[i] == null) continue;
            System.out.println("Пользователь №" + (i + 1));
            System.out.println("Фамилия: " + users[i][0]);
            System.out.println("Имя: " + users[i][1]);
            System.out.println("Отчество: " + users[i][2]);
            System.out.println("Возраст: " + users[i][3]);
            System.out.println("Пол: " + users[i][4] + "\n");
        }
    }
    //Метод для увеличение размерности массива при его переполнении с копированием данных
    private static String[][] expandArray(String[][] arr){
        String[][] temp = new String[arr.length * 2][];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }
}
