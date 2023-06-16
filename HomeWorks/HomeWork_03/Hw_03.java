package HomeWorks.HomeWork_03;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Hw_03 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        
        var nums = fillList(iScanner.nextInt());
        printList(nums, "Сгенерированный список: ");

        nums = revomeEvenNums(nums);
        printList(nums, "Список без четных чисел: ");

        System.out.println("\nМинимальное число: " + Collections.min(nums) + "\nМаксимальное число: " + Collections.max(nums));
        printAvgValue(nums);

        iScanner.close();
    }

    private static void printList(ArrayList<Integer> list,  String msg){
        System.out.println("\n" + msg);
        System.out.println(list.toString());
    }

    private static ArrayList<Integer> fillList(int numOfElements){
        var nums = new ArrayList<Integer>(numOfElements);
        Random rnd = new Random();

        for (int i = 0; i < numOfElements; i++) {
            nums.add(rnd.nextInt(51));
        }

        return nums;
    }

    private static ArrayList<Integer> revomeEvenNums(ArrayList<Integer> nums){
        var oddsNums = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i) % 2 != 0)
                oddsNums.add(nums.get(i));
        }
        
        return oddsNums;
    }

    private static void printAvgValue(ArrayList<Integer> nums){
        double avg = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            avg += nums.get(i);
        }
        
        avg /= nums.size();
        System.out.println("Среднее значение: " + new DecimalFormat("#.##").format(avg));
    }
}
