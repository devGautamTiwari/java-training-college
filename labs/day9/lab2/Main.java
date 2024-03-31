package labs.day9.lab2;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("John", 23);
        treeMap.put("Jane", 25);
        treeMap.put("Doe", 30);
        treeMap.put("Smith", 40);

        System.out.print("Enter a name to search: ");

        String name = scanner.nextLine();
        if (treeMap.containsKey(name)) {
            System.out.println("Age: " + treeMap.get(name));
        } else {
            System.out.println("Name not found");
        }

        scanner.close();
    }
}