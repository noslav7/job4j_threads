package ru.job4j.thread;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Wget implements Runnable {
    private final String url;
    private final int speed;

    public Wget(String url, int speed) {
        this.url = url;
        this.speed = speed;
    }

    @Override
    public void run() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp2.xml")) {

            byte[] dataBuffer = new byte[1024];
            int downloadData = 0;
            int bytesRead;
            long elapsedTime;
            long start = System.currentTimeMillis();

            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);

                downloadData += bytesRead;
                long current;
                if (downloadData >= speed) {
                    current = System.currentTimeMillis();
                    if ((elapsedTime = current - start) < 1000) {
                        Thread.sleep(1000 - elapsedTime);
                    }
                    downloadData = 0;
                    start = System.currentTimeMillis();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void validate(int argsNum) {
        if (argsNum != 2) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        validate(args.length);
        String url = args[0];
        int speed = Integer.parseInt(args[1]);
        Thread wget = new Thread(new Wget(url, speed));
        wget.start();
        wget.join();
    }
}
