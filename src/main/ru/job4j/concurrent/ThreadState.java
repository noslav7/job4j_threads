package ru.job4j.concurrent;

public class ThreadState {

    public static void main(String[] args) {
        Thread main = new Thread(
                () -> {
                }
        );
        Thread first = new Thread(
                () -> {
                }
        );
        first.start();
        main.start();
        while (first.getState() != Thread.State.TERMINATED &&
                main.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getName());
            System.out.println(main.getName());
        }
        System.out.println("Работа завершена");
    }
}
