package ru.job4j.concurrent;

public class ThreadState {

    public static void main(String[] args) {
        Thread main = new Thread(
                () -> {
                    System.out.println("main");
                }
        );

        Thread first = new Thread(
                () -> {
                    System.out.println("first");
                }
        );
        first.start();
        main.start();
        while (first.getState() != Thread.State.TERMINATED ||
                main.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getName());
            System.out.println(main.getName());
        }
        System.out.println("Работа завершена");
    }
}
