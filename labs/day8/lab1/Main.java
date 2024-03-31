package labs.day8.lab1;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("apple", 10);
        hashMap.put("banana", 20);
        hashMap.put("date", 30);

        System.out.println("Fruits in the map: " + hashMap);
    }
}