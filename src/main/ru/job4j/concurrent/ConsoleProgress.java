package ru.job4j.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ConsoleProgress implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.run();
        Thread.sleep(4000);
        progress.interrupt();
    }


    @Override
    public void run() {
        List<Character> symbols = List.of('-', '\\', '|', '/', '-', '\\', '|', '/');
        for (Character symbol : symbols) {
            System.out.print("\r Loading " + symbol);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
