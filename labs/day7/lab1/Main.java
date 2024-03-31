package labs.day7.lab1;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("banana");
        hashSet.add("date");
        hashSet.add("apple");

        System.out.println("Fruits in the set: " + hashSet);

        System.out.print("Enter a fruit: ");
        String fruit = scanner.nextLine();

        hashSet.add(fruit);

        System.out.println("Fruits in the set after updating: " + hashSet);

        scanner.close();
    }
}