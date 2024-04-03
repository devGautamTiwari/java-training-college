package assignment1.lab3;

import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    public static int evenSum() {
        int sum = 0, number;
        String input;
        while (!(input = keyboard.nextLine()).isEmpty()) {
            number = Integer.parseInt(input);
            if (number % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Enter numbers to calculate the sum of even numbers: ");
        System.out.println("Sum of even numbers = " + evenSum());
    }
}
