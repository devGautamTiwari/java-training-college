package labs.day10.lab1;

class Average implements Runnable {
    private int count;

    Average(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i;
        }
        System.out.println("Average: " + (double) sum / count);
    }
}

class Square implements Runnable {
    private int[] arr;

    Square(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Square of " + arr[i] + ": " + arr[i] * arr[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 20, 50, 15, 30 };

        Thread t1 = new Thread(new Average(10));
        Thread t2 = new Thread(new Square(arr));

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.start();
    }
}