package java;

public class ConcurrentOutput {
    public static void main(String[] args) {
        Thread second = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        second.start();
    }
}
