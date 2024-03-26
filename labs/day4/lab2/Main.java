package labs.day4.lab2;


class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}


class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        System.out.println();

        Dog dog = new Dog();
        dog.makeSound();

        System.out.println();

        Cat cat = new Cat();
        cat.makeSound();       
    }
}