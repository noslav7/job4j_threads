package ru.job4j.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

public class Conventional implements Content {
    @Override
    public String getContent(File file) {
        try (BufferedInputStream i = new BufferedInputStream(new FileInputStream(file))) {
            String output = "";
            int data;
            while ((data = i.read()) > 0) {
                output += (char) data;
            }
            return output;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
