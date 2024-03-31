package labs.day8.lab2;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("apple", 10);
        hashMap.put("banana", 20);
        hashMap.put("date", 30);

        System.out.println("Is the HashMap empty? " + hashMap.isEmpty());

        hashMap.clear();

        System.out.println("Is the HashMap empty after clearing? " + hashMap.isEmpty());
    }
}