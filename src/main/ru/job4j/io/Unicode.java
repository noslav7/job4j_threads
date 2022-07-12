package ru.job4j.io;

import java.io.*;

public class Unicode implements Content {

    @Override
    public String getContent(File file) {
        try (BufferedInputStream i = new BufferedInputStream(new FileInputStream(file))) {
            String output = "";
            int data;
            while ((data = i.read()) > 0) {
                if (data < 0x80) {
                    output += (char) data;
                }
            }
            return output;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
