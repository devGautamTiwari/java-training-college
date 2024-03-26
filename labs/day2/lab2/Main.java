package labs.day2.lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        System.out.print("Enter first number: ");
        num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        num2 = scanner.nextInt();

        System.out
                .println("The maximum number between " + num1 + " and " + num2 + " is " + (num1 > num2 ? num1 : num2));
        scanner.close();
    }
}