package labs.day3.lab2;

import java.util.Scanner;

public class Main {

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        System.out.println(year + " is " + (isLeapYear(year) ? "" : "not ") + "a leap year.");
        scanner.close();
    }
}