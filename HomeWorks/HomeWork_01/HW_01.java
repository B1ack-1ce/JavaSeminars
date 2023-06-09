package HomeWorks.HomeWork_01;

import java.util.Random;

public class HW_01 {

    public static void main(String[] args) {
        int i = generationRandomNum();

        int n = older_byte(i);

        int[] m1 = findMultiplesNums(i, n);
        System.out.println("Количество элементов в массиве: " + m1.length + "\n");
        printArr(m1);

        int[] m2 = findNonMultipleNumbers(i, n);
        System.out.println("\nКоличество элементов в массиве: " + m2.length + "\n");
        printArr(m2);
    }

    private static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    //Генерация числа от 0 до 2000
    private static int generationRandomNum(){
        Random rnd = new Random();

        int num = rnd.nextInt(2001);

        return num;
    }
    //Метод для поиска и сохранения самого старшего бита
    public static int older_byte(int i){
        String n = Integer.toBinaryString(i);

        return n.length();
    }
    //Метод для поиска кратных числу multipleNum до диапазона initialPosition
    private static int[] findMultiplesNums(int initialPosition, int multipleNum){
        System.out.println("\nВсе числа в диапазоне от " + initialPosition + " до " + Short.MAX_VALUE + " кратные " + multipleNum + "\n");

        int[] nums = new int[(Short.MAX_VALUE - initialPosition) / multipleNum + 1];//расчет размерности массива, +1 добавил,т.к. через раз выдает ошибку rangeEx, не смог додумать решение
        int index = 0;
        
        while (initialPosition <= Short.MAX_VALUE) {
            if(initialPosition % multipleNum == 0){ //ищем кратные, ничего заурядного 
                nums[index] = initialPosition;
                index++;
            }
            initialPosition++;
        }
        
        return nums;
    }
    //Метод для поиска всех некратных
    private static int[] findNonMultipleNumbers(int finalPosition, int multipleNum){
        System.out.println("\n\nВсе числа в диапазоне от " + Short.MIN_VALUE + " до " + finalPosition + " некратные " + multipleNum + "\n");
        
        int minValue = Short.MIN_VALUE; //кладем минимальное значение Шорта в переменную
        int count = 0;
        //ищем количество КРАТНЫХ элементов, чтобы вычесть их для получения точной размерности массива для НЕкратных
        while(minValue < finalPosition){
            if(minValue % multipleNum == 0){
                count++;
            }
            minValue++;        
        }
        
        int countNumEl = Math.abs(Short.MIN_VALUE) + finalPosition - count + 1; //расчет размерности для некратных элементов числу multipleNum
        int[] nums = new int[countNumEl];
        
        int startPos = Short.MIN_VALUE;
        int index = 0;
        //ищем некратные числа
        while(startPos <= finalPosition){
            if(startPos % multipleNum != 0){
                nums[index] = startPos;
                index++;
            }
            startPos++;
        }
        return nums;
    }
}
