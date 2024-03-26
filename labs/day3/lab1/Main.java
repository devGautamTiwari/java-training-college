package labs.day3.lab1;

import java.util.Scanner;

public class Main {

    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = number;
        int onesPlaceDigit;
        while (temp != 0) {
            onesPlaceDigit = temp % 10;
            sum += factorial(onesPlaceDigit);
            temp /= 10;
        }
        return sum == number;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println(number + " is " + (isStrongNumber(number) ? "" : "not ") + "a strong number.");
        scanner.close();
    }
}