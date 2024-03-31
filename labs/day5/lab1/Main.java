package labs.day5.lab1;

public class Main {
    public static void main(String[] args) {
        int[] intArray = { 1, 2, 3, 4, 5 };
        try {
            for (int i = 0; i < intArray.length + 1; i++) {
                System.out.println("Element at index " + i + ": " + intArray[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds exception occurred.");
        } finally {
            System.out.println("Finally block is executed.");
        }
    }
}