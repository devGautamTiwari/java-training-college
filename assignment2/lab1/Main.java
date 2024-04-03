package assignment2.lab1;

import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    public static void printMenu() {
        System.out.println("1. Add entry");
        System.out.println("2. Get phone number by name");
        System.out.println("3. Exit");
    }

    public static void addEntry(PhoneDirectory phoneDirectory) {
        System.out.print("Enter name: ");
        String name = keyboard.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = keyboard.nextLine();
        phoneDirectory.addEntry(name, phoneNumber);
    }
    
    public static void getPhoneByName(PhoneDirectory phoneDirectory) {
        System.out.print("Enter name: ");
        String name = keyboard.nextLine();
        System.out.println("Phone number: " + (phoneDirectory.getPhoneByName(name) == null ? "Not found" : phoneDirectory.getPhoneByName(name)));
    }

    public static void performAction(int choice, PhoneDirectory phoneDirectory) {
        switch (choice) {
            case 1:
                addEntry(phoneDirectory);
                break;
            case 2:
                getPhoneByName(phoneDirectory);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        int choice;
        do {
            printMenu();
            choice = Integer.parseInt(keyboard.nextLine());

            if (choice == 3)
                break;
            
            performAction(choice, phoneDirectory);

        } while (true);

        System.out.println("Phone directory: ");
        System.out.println(phoneDirectory);

    }
}
