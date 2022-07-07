package ru.job4j.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ConsoleProgress implements Runnable {

    static Thread progress = new Thread(new ConsoleProgress());

    public static void main(String[] args) throws InterruptedException {
        progress.start();
        Thread.sleep(4000);
        progress.interrupt();
    }


    @Override
    public void run() {
        List<Character> symbols = new ArrayList<>();
        symbols.add('-');
        symbols.add('\\');
        symbols.add('|');
        symbols.add('/');
        symbols.add('-');
        symbols.add('\\');
        symbols.add('|');
        symbols.add('/');
        for (Character symbol : symbols) {
            System.out.print("\r Loading " + symbol);
            if (!progress.isInterrupted()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
