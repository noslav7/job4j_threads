package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {

    static Thread progress = new Thread(new ConsoleProgress());

    int[] process = new int[10];

    public static void main(String[] args) throws InterruptedException {
        progress.run();
        Thread.sleep(5000);
        progress.interrupt();
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 4 || i == 8) {
                System.out.print("\r Loading " + process[i] + " -");
            } else if (i == 1 || i == 5 || i == 9) {
                System.out.print("\r Loading " + process[i] + " \\");
            } else if (i == 2 || i == 6) {
                System.out.print("\r Loading " + process[i] + " |");
            } else {
                System.out.print("\r Loading " + process[i] + " /");
            }
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
