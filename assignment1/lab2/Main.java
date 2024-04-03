package assignment1.lab2;

import java.util.ArrayList;

public class Main {

    public static <E> void reverseList(ArrayList<E> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            E temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        reverseList(list);

        for (String item : list) {
            System.out.println(item);
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        reverseList(list2);

        for (Integer item : list2) {
            System.out.println(item);
        }
    }
}
