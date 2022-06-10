package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {

    static Thread progress = new Thread(new ConsoleProgress());

    int[] process = new int[10];

    public static void main(String[] args) throws InterruptedException {
        progress.start();
        Thread.sleep(1000);
        progress.interrupt();
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                while (!progress.isInterrupted()) {
                    System.out.print("\r Loading " + process[i]);
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
