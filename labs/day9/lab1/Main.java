package labs.day9.lab1;

import java.util.HashMap;
import java.util.Scanner;

class PhoneDirectory {
    private HashMap<String, String> phoneDirectory = new HashMap<>();

    private String getPhoneByName(String name) {
        return phoneDirectory.get(name);
    }

    public void getPhoneByName(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().toLowerCase();
        System.out.println("Phone number: "
                + (this.getPhoneByName(name) == null ? "Not found" : this.getPhoneByName(name)));
    }

    private void addEntry(String name, String phoneNumber) {
        phoneDirectory.put(name, phoneNumber);
    }

    public void addEntry(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().toLowerCase();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        this.addEntry(name, phoneNumber);
    }

    public static void printMenu() {
        System.out.println("1. Add entry");
        System.out.println("2. Get phone number by name");
        System.out.println("3. Exit");
    }

    @Override
    public String toString() {
        String output = "";
        for (String name : phoneDirectory.keySet()) {
            output += name + " : " + phoneDirectory.get(name) + ", \n";
        }
        return output;

    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void performAction(int choice, PhoneDirectory phoneDirectory) {
        switch (choice) {
            case 1:
                phoneDirectory.addEntry(scanner);
                break;
            case 2:
                phoneDirectory.getPhoneByName(scanner);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        int choice;
        do {
            PhoneDirectory.printMenu();
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                continue;
            }

            if (choice == 3)
                break;

            performAction(choice, phoneDirectory);

        } while (true);

        System.out.println("Phone directory: ");
        System.out.println(phoneDirectory);

        scanner.close();
    }
}
