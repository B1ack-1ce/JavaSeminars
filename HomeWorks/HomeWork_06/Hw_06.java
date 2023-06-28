package HomeWorks.HomeWork_06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;


public class Hw_06 {
    public static void main(String[] args) {
        Random rnd = new Random();

        Integer[] nums = new Integer[30];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rnd.nextInt(40);
        }

        SetImitation<Integer> setImitation = new SetImitation<Integer>(nums);

        System.out.println(setImitation.size());
        System.out.println(setImitation.isEmpty());
        System.out.println(setImitation.contains(2));

        Iterator<Integer> iterator = setImitation.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        
        System.out.println();
        System.out.println(setImitation.getElementByIndex(3));
    }

}

class SetImitation<E> {
    private HashMap<E, Object> map;
    private static final Object OBJECT = new Object();

    public SetImitation(E[] elements){
        map = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], OBJECT);
        }
    }

    public SetImitation(){
        map = new HashMap<>();
    }

    public boolean add(E num) {
        return map.put(num, OBJECT) == null;
    }

    public boolean delete(E num) {
        return map.remove(num, OBJECT);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object num) {
        return map.containsKey(num);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public E getElementByIndex(int index) {
        E[] mapArray = (E[]) map.keySet().toArray();
        return mapArray[index];
    }

}
