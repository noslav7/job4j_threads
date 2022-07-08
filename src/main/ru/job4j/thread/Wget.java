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
        String file = "https://proof.ovh.net/files/10Mb.dat";
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp2.xml")) {

            byte[] dataBuffer = new byte[1024];
            int downloadData = 0;
            int bytesRead;
            int elapsedTime;

            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                int start = (int) System.currentTimeMillis();
                int current;
                downloadData++;
                if (downloadData == speed) {
                    current = (int) System.currentTimeMillis();
                    if ((elapsedTime = current - start) < 1000) {
                        Thread.sleep(1000 - elapsedTime);
                        downloadData = 0;
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String url = args[0];
        int speed = Integer.parseInt(args[1]);
        Thread wget = new Thread(new Wget(url, speed));
        wget.start();
        wget.join();
    }
}
