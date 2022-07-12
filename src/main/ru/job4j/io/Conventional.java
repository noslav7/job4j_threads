package ru.job4j.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.function.Predicate;

public class Conventional implements Content {
    private File file;

    public Conventional(File file) {
        this.file = file;
    }

    @Override
    public String getContent(Predicate<Character> filter) {
        try (BufferedInputStream i = new BufferedInputStream(new FileInputStream(file))) {
            int data;
            StringBuilder builder = new StringBuilder();
            while ((data = i.read()) > 0) {
                builder.append((char) data);
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
