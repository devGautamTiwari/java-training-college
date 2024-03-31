package labs.day7.lab2;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        System.out.println("Stack: " + stack);

        for (int i = 0; i < 4; i++) {
            stack.pop();
        }

        System.out.println("Stack after popping 4 elements: " + stack);
    }
}